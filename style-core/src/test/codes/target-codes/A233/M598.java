    private List<Integer> processSortTypes(String sortTypes, int totalPages, String pageOrder) {
        try {
            SortTypes mode = SortTypes.valueOf(sortTypes.toUpperCase());
            switch (mode) {
                case REVERSE_ORDER:
                    return reverseOrder(totalPages);
                case DUPLEX_SORT:
                    return duplexSort(totalPages);
                case BOOKLET_SORT:
                    return bookletSort(totalPages);
                case SIDE_STITCH_BOOKLET_SORT:
                    return sideStitchBooklet(totalPages);
                case ODD_EVEN_SPLIT:
                    return oddEvenSplit(totalPages);
                case ODD_EVEN_MERGE:
                    return oddEvenMerge(totalPages);
                case REMOVE_FIRST:
                    return removeFirst(totalPages);
                case REMOVE_LAST:
                    return removeLast(totalPages);
                case REMOVE_FIRST_AND_LAST:
                    return removeFirstAndLast(totalPages);
                case DUPLICATE:
                    return duplicate(totalPages, pageOrder);
                default:
                    throw new IllegalArgumentException("Unsupported custom mode");
            }
        } catch (IllegalArgumentException e) {
            log.error("Unsupported custom mode", e);
            return null;
        }
    }
