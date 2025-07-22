    private void fillComment(CellWriteHandlerContext cellWriteHandlerContext, CommentData commentData) {
        if (commentData == null) {
            return;
        }
        ClientAnchor anchor;
        Integer rowIndex = cellWriteHandlerContext.getRowIndex();
        Integer columnIndex = cellWriteHandlerContext.getColumnIndex();
        Sheet sheet = cellWriteHandlerContext.getWriteSheetHolder().getSheet();
        Cell cell = cellWriteHandlerContext.getCell();

        if (writeContext.writeWorkbookHolder().getExcelType() == ExcelTypeEnum.XLSX) {
            anchor = new XSSFClientAnchor(StyleUtil.getCoordinate(commentData.getLeft()),
                StyleUtil.getCoordinate(commentData.getTop()),
                StyleUtil.getCoordinate(commentData.getRight()),
                StyleUtil.getCoordinate(commentData.getBottom()),
                StyleUtil.getCellCoordinate(columnIndex, commentData.getFirstColumnIndex(),
                    commentData.getRelativeFirstColumnIndex()),
                StyleUtil.getCellCoordinate(rowIndex, commentData.getFirstRowIndex(),
                    commentData.getRelativeFirstRowIndex()),
                StyleUtil.getCellCoordinate(columnIndex, commentData.getLastColumnIndex(),
                    commentData.getRelativeLastColumnIndex()) + 1,
                StyleUtil.getCellCoordinate(rowIndex, commentData.getLastRowIndex(),
                    commentData.getRelativeLastRowIndex()) + 1);
        } else {
            anchor = new HSSFClientAnchor(StyleUtil.getCoordinate(commentData.getLeft()),
                StyleUtil.getCoordinate(commentData.getTop()),
                StyleUtil.getCoordinate(commentData.getRight()),
                StyleUtil.getCoordinate(commentData.getBottom()),
                (short)StyleUtil.getCellCoordinate(columnIndex, commentData.getFirstColumnIndex(),
                    commentData.getRelativeFirstColumnIndex()),
                StyleUtil.getCellCoordinate(rowIndex, commentData.getFirstRowIndex(),
                    commentData.getRelativeFirstRowIndex()),
                (short)(StyleUtil.getCellCoordinate(columnIndex, commentData.getLastColumnIndex(),
                    commentData.getRelativeLastColumnIndex()) + 1),
                StyleUtil.getCellCoordinate(rowIndex, commentData.getLastRowIndex(),
                    commentData.getRelativeLastRowIndex()) + 1);
        }

        Comment comment = sheet.createDrawingPatriarch().createCellComment(anchor);
        if (commentData.getRichTextStringData() != null) {
            comment.setString(
                StyleUtil.buildRichTextString(writeContext.writeWorkbookHolder(), commentData.getRichTextStringData()));
        }
        if (commentData.getAuthor() != null) {
            comment.setAuthor(commentData.getAuthor());
        }
        cell.setCellComment(comment);
    }
