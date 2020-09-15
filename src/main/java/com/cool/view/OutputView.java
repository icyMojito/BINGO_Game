package com.cool.view;

import com.cool.bingo.BingoNumber;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class OutputView {
    private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final String NEW_LINE = System.lineSeparator();
    private static final String SPACE = " ";
    private static final String DOUBLE_SPACE = "  ";
    private static final String TRIPLE_SPACE = "   ";
    public static final String NUMBER_DELIMITER = ",";

    public static void printRequestForBingoSize() throws IOException {
        bufferedWriter.write("👼🏼 " + ViewColor.MAGENTA_BOLD.fillText("빙고판의 크기") + "를 입력해 주세요!");
        bufferedWriter.newLine();
        bufferedWriter.write("⚠️ 빙고판의 크기는 " + ViewColor.YELLOW_UNDERLINED.fillText("3X3부터 8X8까지")
                                     + " 지정할 수 있으며, " + ViewColor.RED_BOLD.fillText("숫자만") + " 입력 가능해요.");
        bufferedWriter.newLine();
        bufferedWriter.write("   예를 들어 4X4로 하고 싶으면 4만 적어주세요.");
        bufferedWriter.newLine();
        bufferedWriter.write("➡️ ");

        bufferedWriter.flush();
    }

    public static void printRequestForBingoType() throws IOException {
        bufferedWriter.write("👼🏼 " + ViewColor.MAGENTA_BOLD.fillText("빙고의 종류") + "를 입력해 주세요!");
        bufferedWriter.newLine();
        bufferedWriter.write("⚠️ 빙고의 종류는 " + ViewColor.BLACK_UNDERLINED.fillText("블랙빙고")
                                     + " 혹은 "
                                     + ViewColor.GREEN_UNDERLINED.fillText("N빙고")
                                     + "로 지정할 수 있으며, "
                                     + ViewColor.BLUE_UNDERLINED.fillText("랜덤")
                                     + " 선택도 가능합니다. "
                                     + ViewColor.BLACK_BOLD.fillText("블랙빙고는 B(b)")
                                     + ","
                                     + ViewColor.GREEN_BOLD.fillText("N빙고는 N(n)")
                                     + ","
                                     + ViewColor.BLUE_BOLD.fillText("랜덤 지정은 R(r)")
                                     + "을 입력해 주세요.");
        bufferedWriter.newLine();
        bufferedWriter.write("➡️ ");

        bufferedWriter.flush();
    }

    public static void printRequestForBingoNumber(int bingoLineCount) throws IOException {
        int totalBingoNumbersCount = (int) Math.pow(bingoLineCount, 2);
        int maxNumber = (int) Math.pow(bingoLineCount, 2) * 2;

        bufferedWriter.write("👼🏼 " + ViewColor.MAGENTA_BOLD.fillText("빙고에 넣을 숫자 " + totalBingoNumbersCount + "개")
                                     + "를 한 줄(" + bingoLineCount + "개)씩 입력해 주세요!");
        bufferedWriter.newLine();
        bufferedWriter.write("숫자 사이는 \"" + NUMBER_DELIMITER + "\"로 구별이 필요해요. 꼭 넣어주세요~");
        bufferedWriter.newLine();
        bufferedWriter.write("⚠️ 빙고의 숫자는 " + ViewColor.YELLOW_UNDERLINED.fillText("1부터 " + maxNumber + "까지")
                                     + " 입력할 수 있으며, " + ViewColor.BLACK_BOLD.fillText("숫자만 ")
                                     + ViewColor.BLUE_BOLD.fillText("중복 없이") + " 입력 가능해요.");
        bufferedWriter.newLine();

        bufferedWriter.flush();
    }

    public static void printRequestForNumberInput() throws IOException {
        bufferedWriter.write("➡️ ");
        bufferedWriter.flush();
    }

    public static void printBingoBoard(BingoNumber[][] cells) throws IOException {
        StringBuilder bingoBoard = new StringBuilder();

        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                BingoNumber bingoNumber = cells[row][col];
                String value = Objects.isNull(bingoNumber) ? "." : bingoNumber.getValue();
                String space = value.length() == 1 ? TRIPLE_SPACE : value.length() == 2 ? DOUBLE_SPACE : SPACE;
                bingoBoard.append(value)
                        .append(space);
            }
            bingoBoard.append(NEW_LINE);
        }

        bufferedWriter.write(bingoBoard.toString());
        bufferedWriter.flush();
    }

    public static void close() throws IOException {
        bufferedWriter.close();
    }
}
