    private JsonNode validateLicense(
            String licenseKey, String machineFingerprint, LicenseContext context) throws Exception {
        String requestBody =
                String.format(
                        "{\"meta\":{\"key\":\"%s\",\"scope\":{\"fingerprint\":\"%s\"}}}",
                        licenseKey, machineFingerprint);
        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(
                                URI.create(
                                        BASE_URL
                                                + "/"
                                                + ACCOUNT_ID
                                                + "/licenses/actions/validate-key"))
                        .header("Content-Type", "application/vnd.api+json")
                        .header("Accept", "application/vnd.api+json")
                        // .header("Authorization", "License " + licenseKey)
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        log.debug("ValidateLicenseResponse body: {}", response.body());
        JsonNode jsonResponse = objectMapper.readTree(response.body());
        if (response.statusCode() == 200) {
            JsonNode metaNode = jsonResponse.path("meta");
            boolean isValid = metaNode.path("valid").asBoolean();

            String detail = metaNode.path("detail").asText();
            String code = metaNode.path("code").asText();

            log.info("License validity: {}", isValid);
            log.info("Validation detail: {}", detail);
            log.info("Validation code: {}", code);

            // Check if the license itself has floating attribute
            JsonNode licenseAttrs = jsonResponse.path("data").path("attributes");
            if (!licenseAttrs.isMissingNode()) {
                context.isFloatingLicense = licenseAttrs.path("floating").asBoolean(false);
                context.maxMachines = licenseAttrs.path("maxMachines").asInt(1);

                log.info(
                        "License floating (from license): {}, maxMachines: {}",
                        context.isFloatingLicense,
                        context.maxMachines);
            }

            // Also check the policy for floating license support if included
            JsonNode includedNode = jsonResponse.path("included");
            JsonNode policyNode = null;

            if (includedNode.isArray()) {
                for (JsonNode node : includedNode) {
                    if ("policies".equals(node.path("type").asText())) {
                        policyNode = node;
                        break;
                    }
                }
            }

            if (policyNode != null) {
                // Check if this is a floating license from policy
                boolean policyFloating =
                        policyNode.path("attributes").path("floating").asBoolean(false);
                int policyMaxMachines = policyNode.path("attributes").path("maxMachines").asInt(1);

                // Policy takes precedence over license attributes
                if (policyFloating) {
                    context.isFloatingLicense = true;
                    context.maxMachines = policyMaxMachines;
                }

                log.info(
                        "License floating (from policy): {}, maxMachines: {}",
                        context.isFloatingLicense,
                        context.maxMachines);
            }

            // Extract user count, default to 1 if not specified
            int users =
                    jsonResponse
                            .path("data")
                            .path("attributes")
                            .path("metadata")
                            .path("users")
                            .asInt(1);
            applicationProperties.getPremium().setMaxUsers(users);

            // Extract isEnterprise flag
            context.isEnterpriseLicense =
                    jsonResponse
                            .path("data")
                            .path("attributes")
                            .path("metadata")
                            .path("isEnterprise")
                            .asBoolean(false);

            log.debug(applicationProperties.toString());

        } else {
            log.error("Error validating license. Status code: {}", response.statusCode());
        }
        return jsonResponse;
    }
