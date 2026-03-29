---
name: test-oracle-runner
description: >-
  Generates test cases together with explicit oracles (expected values, assertions,
  golden files, or behavioral contracts) and runs only the tests the user specifies.
  For the style-transformer repo: style transfer uses (src, target) pairs with
  golden source oracles named *-gt.<lang>; inconsistency analysis uses the same
  pairs with text oracles *-inc.txt matching Coordinator output and
  InconsistencyInfo / InconsistencyInfoGenerator. Use when the user wants test
  generation with expected outcomes, oracle design, selective test execution,
  or batch test scaffolding. Also use for Chinese queries about 测试用例、Oracle、
  期望结果、风格转换、不一致性分析、-gt、-inc、选择性执行.
---

# Test generation with oracles and selective execution

## Goal

Produce **test cases** where every case has a **paired oracle** (how to know it passed), then **run only** what the user chooses—never assume "run all" without confirmation when this skill applies.

## When to read more

- General oracle shapes: [references/oracle-patterns.md](references/oracle-patterns.md).
- **This repository (`style-core`)** — style transfer `*-gt.*` and inconsistency `*-inc.txt`, report format, reusing migration fixtures: [references/style-transformer-testing.md](references/style-transformer-testing.md).

---

## Phase 1 — Intake (short)

Before generating, confirm or infer:

1. **Target**: class/module/API/file under test.
2. **Test kind**: unit, integration, end-to-end, or mixed.
3. **Framework**: detect from repo (`pom.xml`, `build.gradle`, `pytest.ini`, `package.json`, etc.).
4. **Constraints**: time budget, flakiness rules (avoid real network unless asked), data/fixtures location.

If anything critical is missing, ask one compact question; otherwise proceed with sensible defaults and state assumptions in the catalog.

---

## Phase 2 — Generate catalog (tests + oracle)

Output a **Test catalog** in the conversation (and mirror into a file under the repo only if the user asked for files). Use this structure for **each** test:

```markdown
### T-001 — [short name]
- **Intent**: what behavior is proven
- **Arrange**: inputs / fixtures / mocks
- **Act**: single call or short sequence
- **Oracle**:
  - **Type**: (exact | golden | invariant | mock | error | snapshot)
  - **Expected**: concrete expected value OR path to golden OR predicate OR expected exception
  - **Assertion**: example one-liner in the project's test framework
- **Notes**: edge cases, flakiness risks, or "not parallel-safe" if any
```

Rules:

- Every ID must have an oracle; if the user only asked for "test ideas," still attach a proposed oracle.
- Prefer **objective** oracles; if the outcome is subjective, say so and propose a **checklist oracle** (human-verifiable steps) as fallback.
- Align naming and style with existing tests in the same directory.

### Repository-specific: `style-core`

When tests live under `style-core`:

1. **Style transfer**: catalog each case as `(src, target)`; oracle = file **`basename(src)` with `-gt` before the extension** (e.g. `f1.java` → `f1-gt.java`). Target is the style reference; src is what gets transformed.
2. **Style inconsistency analysis**: same `(src, target)` pairing; oracle = **replace `.<language>` with `-inc.txt`** on the src path (e.g. `f1.java` → `f1-inc.txt`). Content must match **`Coordinator.analyzeInconsistency`** output (`InconsistencyInfo.toString()` blocks); semantics follow **`InconsistencyInfoGenerator`** (and related styler analyzers).
3. **New inconsistency fixtures**: pick **src/target from existing style-migration test cases** in the same `src/test/sources/...` area instead of inventing unrelated pairs.

See [references/style-transformer-testing.md](references/style-transformer-testing.md) for format details and code pointers.

---

## Phase 3 — User selection (mandatory gate)

Present a **numbered list** of test IDs (`T-001`, `T-002`, …) with one-line summaries.

Ask explicitly, in the user's language if they used Chinese:

- Which IDs to **implement** (if not already coded),
- Which IDs to **run** after implementation.

Accept answers like: `T-001,T-003`, `all`, `except T-002`, `smoke only` (then map smoke to a subset you defined in Notes).

**Do not** run the full suite as a substitute for selection unless the user chose `all` or equivalent.

---

## Phase 4 — Implement (only selected)

For selected IDs only:

1. Add or edit test code following project conventions.
2. Keep oracle and assertion **visible** in the test (or in a clearly linked golden file).
3. Do not add unrelated tests.

---

## Phase 5 — Execute (only selected)

1. Resolve the project's standard command:
   - **Maven**: e.g. `mvn -pl <module> -Dtest=ClassName#method test`
   - **Gradle**: e.g. `./gradlew test --tests "pkg.Class.method"`
   - **pytest**: `pytest path::test_name`
   - **npm**: `npm test -- -t "pattern"`

2. Run **only** the selected tests (class/method/file pattern). If the tool does not support fine granularity, run the smallest enclosing scope and **report** that limitation.

3. Summarize: pass/fail per ID, link to assertion/golden that failed, and minimal fix guidance.

---

## Phase 6 — If failures occur

- Distinguish **wrong SUT** vs **wrong oracle** vs **environment**.
- Update either implementation or oracle with user agreement; do not weaken assertions silently.

---

## Checklist (agent)

- [ ] Catalog lists every test with a defined oracle
- [ ] User confirmed which IDs to implement and/or run
- [ ] Commands target only selected tests where possible
- [ ] Results mapped back to catalog IDs

## Common pitfalls
1. Do not generate any test class or test method unless explicitly be asked to do so.