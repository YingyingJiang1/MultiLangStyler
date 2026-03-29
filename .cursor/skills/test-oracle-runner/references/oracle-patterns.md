# Oracle patterns (reference)

An **oracle** is anything that decides pass/fail: expected output, invariant, snapshot, or mock contract.

| Pattern | When to use | Oracle form |
|--------|-------------|-------------|
| **Exact assertion** | Deterministic pure logic | Concrete expected value + matcher (`assertEquals`, `toBe`, etc.) |
| **Property / invariant** | Many inputs | Predicate over result + documented edge cases |
| **Golden file** | Text/binary output | Path to baseline + how to update (`-DupdateSnapshots` etc.) |
| **Behavioral mock** | Side effects / I/O | Expected call counts, arguments, or sequence |
| **Error oracle** | Negative tests | Exact exception type + message substring or error code |
| **Regression snapshot** | Large structured output | Approved fixture committed beside test |

Each generated test should state **why** the oracle is sufficient (one line): e.g. "output is fully determined by input X and config Y."

---

## File oracles in this workspace (`style-core`)

For **style transfer** and **inconsistency analysis**, file naming and report layout are fixed — see [style-transformer-testing.md](style-transformer-testing.md) (`*-gt.<lang>`, `*-inc.txt`, Coordinator / `InconsistencyInfo`).
