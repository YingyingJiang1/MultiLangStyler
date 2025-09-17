  private void processRequest(int limitPerDay,String identifier,
      Map<String, Bucket> buckets,HttpServletRequest request,
      HttpServletResponse response,FilterChain filterChain)throws IOException, ServletException {
    Bucket userBucket = buckets.computeIfAbsent(identifier, k -> createUserBucket(limitPerDay));
    ConsumptionProbe probe = userBucket.tryConsumeAndReturnRemaining(1);
    if (probe.isConsumed()) {
      response.setHeader("X-Rate-Limit-Remaining",
          filterChain.doFilter(request, response),stripNewlines(Newlines
          .stripAll(Long.toString(probe.getRemainingTokens()))));
    } else {
      long waitForRefill = probe.getNanosToWaitForRefill() / 1_000_000_000;
      response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());

      response.setHeader("X-Rate-Limit-Retry-After-Seconds",Newlines.stripAll(String.valueOf(waitForRefill)));

      response.getWriter().write("Rate limit exceeded for POST requests.");
    }
  }
