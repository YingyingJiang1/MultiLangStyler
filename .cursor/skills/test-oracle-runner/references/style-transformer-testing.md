# Style transformer repo — test pairs and file oracles

Use this file when working under `style-core` (style transfer + inconsistency analysis).

## Shared notion: style transfer pair

Both **style transfer (apply)** tests and **style inconsistency analysis** tests are driven by a pair:

| Role | Meaning |
|------|---------|
| **src** | Source file to analyze or to transform |
| **target** | Reference for the **target style** (another source file or style profile, per existing tests) |

Keep the same `(src, target)` relationship as the corresponding style-migration fixture in `style-core/src/test/sources/`.

---

## A) Style transfer — oracle file

- **Oracle type**: source file in the **same programming language** as `src` (e.g. Java → `.java`).
- **Naming**: insert **`-gt`** before the language extension.

Examples:

| src | Oracle (golden transformed output) |
|-----|-------------------------------------|
| `f1.java` | `f1-gt.java` |
| `Foo.kt` | `Foo-gt.kt` |

**Assertion**: normalized comparison of transformed `src` against the oracle file (as existing styler tests do with `*-gt.java`).

---

## B) Style inconsistency analysis — oracle file

- **Oracle type**: **plain text** `.txt`.
- **Naming**: replace the language extension with **`-inc.txt`** (same rule as `TestCoordinatorAnalyzeJava#createTaskOptions`: `taskOptions.getSrc().replace("." + LANG, "-inc.txt")`).

Examples:

| src | Oracle (expected report) |
|-----|-------------------------|
| `f1.java` | `f1-inc.txt` |
| `f1-gt.java` | `f1-gt-inc.txt` |

So the oracle name is always **`basename(src)` with `.<lang>` → `-inc.txt`**, not a separate rule for “gt”.

### What must appear inside `*-inc.txt`

The golden file must match the **exact text** that `Coordinator.analyzeInconsistency` writes when `TaskOptions.resOutPath` points at the temp/output file:

1. For each entry in the analyzed map, a block:
   - A line of `=` × 60
   - `File: <path key>` (as produced by the coordinator / analyzer map key)
   - `Total Inconsistencies: <n>`
   - A line of `=` × 60
   - For each `InconsistencyInfo`, one line: `[i] ` + `info.toString()` (multiline string from `InconsistencyInfo.toString()`).

2. **Semantic content** of each `InconsistencyInfo` (message, expected/actual, locations) comes from styler-specific logic, including **`InconsistencyInfoGenerator`** and related analyzers. When authoring or refreshing a golden file, align with that implementation rather than inventing ad hoc wording.

**Practical workflow to produce or update a golden `*-inc.txt`**: run inconsistency analysis on `(src, target)` with output to a temporary file, normalize line endings to LF, and treat that as the oracle (or diff against existing golden).

---

## C) Choosing cases for inconsistency tests

- **Do not** invent unrelated `(src, target)` pairs for inconsistency-only fixtures.
- **Prefer** reusing the same **src/target files and directories** already used by **style migration / styler** tests under `src/test/sources/...`, so transfer behavior and analysis stay aligned.

---

## Code pointers

- Report layout: `style-core/src/main/java/org/example/stylekit/Coordinator.java` (`analyzeInconsistency`, `StringBuilder` + file write).
- Line format per inconsistency: `style-core/src/main/java/org/example/style/InconsistencyInfo.java` (`toString()`).
- Message / field construction for many kinds: `style-core/src/main/java/org/example/styler/InconsistencyInfoGenerator.java`.
- Example harness comparing tmp output to golden: `style-core/src/test/java/org/example/stylekit/TestCoordinatorAnalyzeJava.java`.
