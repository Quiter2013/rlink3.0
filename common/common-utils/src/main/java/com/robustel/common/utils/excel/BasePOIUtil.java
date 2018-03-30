package com.robustel.common.utils.excel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class BasePOIUtil {

	private Sheet sheet;
	private Workbook wb;

	public BasePOIUtil(Workbook wb, Sheet sheet) {
		this.sheet = sheet;
		this.wb = wb;
	}

	/**
	 * 合并单元格 设表框
	 * 
	 * @param border
	 *            大小
	 * @param cellRangeAddress
	 * @param sheet
	 * @param wb
	 */
	public void setRegionBorder(int border, CellRangeAddress cellRangeAddress) {
		RegionUtil.setBorderBottom(border, cellRangeAddress, sheet, wb);
		RegionUtil.setBorderLeft(border, cellRangeAddress, sheet, wb);
		RegionUtil.setBorderRight(border, cellRangeAddress, sheet, wb);
		RegionUtil.setBorderTop(border, cellRangeAddress, sheet, wb);
	}

	public void MergeCell(int firstRow, int lastRow, int firstCol, int lastCol) {
		CellRangeAddress cellRangeAddress = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		setRegionBorder(1, cellRangeAddress);
		sheet.addMergedRegion(cellRangeAddress);
	}

	/**
	 * 增加 边框 样式
	 * 
	 * @param wb
	 * @param sheet
	 * @param cellStyle
	 * @return
	 */
	public CellStyle getBorderStyle(CellStyle cellStyle) {
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return cellStyle;

	}

	/**
	 * 附加 字体样式
	 * 
	 * @param wb
	 * @param cellStyle
	 * @return
	 */
	public Font getFont(int fontSize, String fontName, int Boldweight) {
		Font font = wb.createFont();
		if (fontSize <= 0) {
			fontSize = 10;
		}
		font.setFontHeightInPoints((short) fontSize);
		if (fontName == null || fontName.length() < 1) {
			fontName = "Arial";
		}
		font.setFontName(fontName);
		font.setBoldweight((short) Boldweight);
		// font.setItalic(true);
		// font.setStrikeout(true);
		return font;
	}

	/**
	 * 遍历CELL 设样式
	 * 
	 * @param wb
	 * @param sheet
	 * @param cellStyle
	 */
	public void setCellStyles(CellStyle cellStyle) {
		int lastRow = sheet.getLastRowNum();
		for (Row row : sheet) {
			if (lastRow != row.getRowNum()) {
				for (Cell cell : row) {
					cell.setCellStyle(cellStyle);
				}
			}
		}
	}

	/**
	 * 设置文本单元格
	 * 
	 * @param columNum
	 */
	public void setCellText(String[] columNum) {
		List<String> list = Arrays.asList(columNum);
		int lastRow = sheet.getLastRowNum();
		CellStyle txtStyle = getBorderStyle(wb.createCellStyle());
		;
		txtStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("@"));
		txtStyle.setFont(getFont(8, "", 1));
		for (Row row : sheet) {
			if (lastRow != row.getRowNum()) {
				for (Cell cell : row) {
					int cellIndex = cell.getColumnIndex();
					if (list.contains(cellIndex + "")) {
						cell.setCellStyle(txtStyle);
					}
				}
			}
		}

	}

	/**
	 * 一位小数点
	 * 
	 * @param ticketSizeCellMap
	 */
	public void setCellStyle4TicketSize(Map<Integer, Integer> ticketSizeCellMap) {
		CellStyle txtStyle = getBorderStyle(wb.createCellStyle());
		;
		txtStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.0"));
		txtStyle.setFont(getFont(8, "", 1));
		for (Row row : sheet) {
			Set<Integer> rowSet = ticketSizeCellMap.keySet();
			if (rowSet.contains(row.getRowNum())) {
				for (Cell cell : row) {
					int cellIndex = cell.getColumnIndex();
					if (cellIndex == ticketSizeCellMap.get(row.getRowNum())) {
						cell.setCellStyle(txtStyle);
					}
				}
			}
		}

	}

	/**
	 * 设标题样式
	 * 
	 * @param wb
	 * @param sheet
	 * @param rowid
	 * @param columnid
	 * @param cellStyle
	 */
	public void setTitleStyle(int rowid, int columnid, CellStyle cellStyle) {

		Row row = sheet.getRow(rowid);
		Cell cell = row.getCell(columnid);
		Font font = getFont(20, "宋体", 1);
		cellStyle.setFont(font);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cell.setCellStyle(cellStyle);
		row.setHeight((short) (20 * 24));
	}

	public void setTitleStyle2(int rowid, int columnid, CellStyle cellStyle) {
		Row row = sheet.getRow(rowid);
		Cell cell = row.getCell(columnid);
		Font font = getFont(10, "宋体", 1);
		cellStyle.setFont(font);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cell.setCellStyle(cellStyle);
	}

	/**
	 * 设通用样式（10宋体标题20）
	 * 
	 * @param wb
	 * @param sheet
	 * @param startRow
	 * @param startCol
	 */
	public void setGAStyle(int startRow, int startCol, String[] notmoneyCol) {
		List<String> collst = Arrays.asList(notmoneyCol);
		CellStyle textStyle = getBorderStyle(wb.createCellStyle());
		textStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		textStyle.setFont(getFont(8, "", 1));

		CellStyle moneyStyle = getBorderStyle(wb.createCellStyle());
		;
		short doubleFormat = HSSFDataFormat.getBuiltinFormat("#,##0");
		moneyStyle.setDataFormat(doubleFormat);
		moneyStyle.setFont(getFont(8, "", 1));

		int lastRow = sheet.getLastRowNum();
		for (Row row : sheet) {
			if (lastRow != row.getRowNum()) {
				for (Cell cell : row) {
					int ColumnIDX = cell.getColumnIndex();
					if (collst.contains(ColumnIDX + "")) {
						cell.setCellStyle(textStyle);
					} else {
						// 设置千分位
						cell.setCellStyle(moneyStyle);

					}
				}
			} else {
				CellStyle textStyle2 = getBorderStyle(wb.createCellStyle());
				textStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
				for (Cell cell : row) {
					cell.setCellStyle(textStyle2);
				}
			}
		}

		// CellStyle cs= getBorderStyle(wb.createCellStyle());
		// setTitleStyle2(startRow+1, startCol,cs);
		CellStyle cs2 = getBorderStyle(wb.createCellStyle());
		setTitleStyle(startRow, startCol, cs2);
		setPrintStyle(true, true, true);
	}

	/**
	 * 设置列水平位置
	 * 
	 * @param startRow
	 * @param startCol
	 * @param column
	 * @param align
	 */
	public void setTDAlign(int startRow, int endRow, String[] column, short align) {
		List<String> cols = Arrays.asList(column);
		CellStyle textStyle = getBorderStyle(wb.createCellStyle());
		textStyle.setAlignment(align);

		int lastRow = sheet.getLastRowNum();
		for (int i = startRow; i <= endRow; i++) {
			if (lastRow != sheet.getRow(i).getRowNum()) {
				for (Cell c : sheet.getRow(i)) {
					int cellNum = c.getColumnIndex();
					if (cols.contains(cellNum + "")) {
						c.setCellStyle(textStyle);
					}
				}
			} else {
				CellStyle textStyle2 = getBorderStyle(wb.createCellStyle());
				textStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
				for (Cell c : sheet.getRow(i)) {
					c.setCellStyle(textStyle2);
				}
			}
		}
	}

	/**
	 * 设置打印风格
	 * 
	 * @param printDirection
	 *            打印方向，true:横向，false:纵向
	 * @param horizon//true
	 *            设置打印页面为水平居中
	 * @param vertical//true
	 *            设置打印页面为垂直居中
	 */
	public void setPrintStyle(boolean printDirection, boolean horizon, boolean vertical) {
		PrintSetup ps = sheet.getPrintSetup();
		ps.setLandscape(printDirection); // 打印方向，true:横向，false:纵向
		ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 纸张
		sheet.setMargin(HSSFSheet.BottomMargin, (double) 0.3); // 页边距（下）
		sheet.setMargin(HSSFSheet.LeftMargin, (double) 0.1); // 页边距（左）
		sheet.setMargin(HSSFSheet.RightMargin, (double) 0.1); // 页边距（右）
		sheet.setMargin(HSSFSheet.TopMargin, (double) 0.3); // 页边距（上）
		sheet.setHorizontallyCenter(horizon); // 设置打印页面为水平居中
		sheet.setVerticallyCenter(vertical); // 设置打印页面为垂直居中
	}

	/**
	 * 设置列字体颜色
	 * 
	 * @param colNums
	 * @param color
	 */
	public void setColumnsColor(String[] colNums, short color) {
		List<String> cols = Arrays.asList(colNums);
		CellStyle cs = getBorderStyle(wb.createCellStyle());
		Font f = getFont(8, "宋体", 1);
		f.setColor(color);
		cs.setFont(f);
		int lastRow = sheet.getLastRowNum();
		for (Row r : sheet) {
			if (lastRow != r.getRowNum()) {
				for (Cell c : r) {
					int cellNum = c.getColumnIndex();
					if (cols.contains(cellNum + "")) {
						c.setCellStyle(cs);
					}
				}
			}
		}
	}

	/**
	 * 设置行背景颜色
	 * 
	 * @param colNums
	 * @param color
	 */
	public void setRowColor(String[] row, short color, short align, String[] td, int fontSize, short fontColor) {
		CellStyle cellStyleTitle = wb.createCellStyle();
		cellStyleTitle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); // 填充单元格
		cellStyleTitle.setFillForegroundColor(color);
		cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyleTitle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyleTitle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyleTitle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyleTitle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		if (fontSize != -1) {
			Font f = getFont(fontSize, "宋体", 1);
			if (fontColor != -1) {
				f.setColor(fontColor);
			}
			cellStyleTitle.setFont(f);
		}

		CellStyle cellStyleTitle2 = wb.createCellStyle();
		cellStyleTitle2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); // 填充单元格
		cellStyleTitle2.setFillForegroundColor(color);
		cellStyleTitle2.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyleTitle2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyleTitle2.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyleTitle2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyleTitle2.setBorderRight(CellStyle.BORDER_THIN);
		cellStyleTitle2.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyleTitle2.setBorderTop(CellStyle.BORDER_THIN);
		cellStyleTitle2.setTopBorderColor(IndexedColors.BLACK.getIndex());
		if (align != -1) {
			cellStyleTitle2.setAlignment(align);
		}

		List<String> lst = null;
		if (td != null) {
			lst = Arrays.asList(td);
		}
		for (String key : row) {
			if (key == null || "".equals(key.trim())) {
				continue;
			}
			int celNm = sheet.getRow(Integer.parseInt(key)).getLastCellNum();
			for (int i = 0; i < celNm; i++) {
				Cell lastCell = sheet.getRow(Integer.parseInt(key)).getCell(i);

				if (lst != null && lst.size() > 0 && lst.contains(i + "")) {
					lastCell.setCellStyle(cellStyleTitle2);
				} else {
					lastCell.setCellStyle(cellStyleTitle);
				}
			}
		}
	}

	/**
	 * 设置行背景颜色
	 * 
	 * @param colNums
	 * @param color
	 */
	public void setRowBorber(String[] row, boolean type) {
		CellStyle cellStyleTitle = wb.createCellStyle();
		cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);
		if (type) {
			cellStyleTitle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			cellStyleTitle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			cellStyleTitle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyleTitle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		} else {
			cellStyleTitle.setBottomBorderColor(IndexedColors.WHITE.getIndex());
			cellStyleTitle.setLeftBorderColor(IndexedColors.WHITE.getIndex());
			cellStyleTitle.setRightBorderColor(IndexedColors.WHITE.getIndex());
			cellStyleTitle.setTopBorderColor(IndexedColors.WHITE.getIndex());
		}

		for (String key : row) {
			if (key == null || "".equals(key.trim())) {
				continue;
			}
			int celNm = sheet.getRow(Integer.parseInt(key)).getLastCellNum();
			for (int i = 0; i < celNm; i++) {
				Cell lastCell = sheet.getRow(Integer.parseInt(key)).getCell(i);

				lastCell.setCellStyle(cellStyleTitle);
			}
		}
	}

	public static void main(String[] args) {
		String[] a = { "11", "1" };
		List<String> lst = Arrays.asList(a);

		System.out.println(lst.contains(1));
		System.out.println(lst.contains(1 + ""));
	}

}
