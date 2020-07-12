package com.shreyansh.tictictoe;

public class TicTacToeModel {
    int flag;
    int win;
    int score1;
    int score2;
    boolean player1ax;
    String player1;
    String player2;
    String roomOwner;
    int ax;
    int zero;
    int resetchecker;
    int drawchecker;
    int currentgamedonechecker;
    int ctrflag;
    int game;
    String result;
    String player_turn;

    int sum0;
    int sum1;
    int sum2;
    int sum3;
    int sum4;
    int sum5;
    int sum6;
    int sum7;

    int tracker00;
    int tracker01;
    int tracker02;
    int tracker10;
    int tracker11;
    int tracker12;
    int tracker20;
    int tracker21;
    int tracker22;

    int buttonpressed00;
    int buttonpressed01;
    int buttonpressed02;
    int buttonpressed10;
    int buttonpressed11;
    int buttonpressed12;
    int buttonpressed20;
    int buttonpressed21;
    int buttonpressed22;

    public TicTacToeModel() {}

    public TicTacToeModel(int flag, int win, int sum0, int sum1, int sum2, int sum3, int sum4, int sum5, int sum6, int sum7, int tracker00, int tracker01, int tracker02, int tracker10, int tracker11, int tracker12, int tracker20, int tracker21, int tracker22, int score1, int score2, int buttonpressed00, int buttonpressed01, int buttonpressed02, int buttonpressed10, int buttonpressed11, int buttonpressed12, int buttonpressed20, int buttonpressed21, int buttonpressed22, boolean player1ax, String player1, String player2, String roomOwner, int ax, int zero, int resetchecker, int drawchecker, int currentgamedonechecker, int ctrflag, int game, String result,String player_turn) {
        this.flag = flag;
        this.win = win;
        this.sum0 = sum0;
        this.sum1 = sum1;
        this.sum2 = sum2;
        this.sum3 = sum3;
        this.sum4 = sum4;
        this.sum5 = sum5;
        this.sum6 = sum6;
        this.sum7 = sum7;
        this.tracker00 = tracker00;
        this.tracker01 = tracker01;
        this.tracker02 = tracker02;
        this.tracker10 = tracker10;
        this.tracker11 = tracker11;
        this.tracker12 = tracker12;
        this.tracker20 = tracker20;
        this.tracker21 = tracker21;
        this.tracker22 = tracker22;
        this.score1 = score1;
        this.score2 = score2;
        this.buttonpressed00 = buttonpressed00;
        this.buttonpressed01 = buttonpressed01;
        this.buttonpressed02 = buttonpressed02;
        this.buttonpressed10 = buttonpressed10;
        this.buttonpressed11 = buttonpressed11;
        this.buttonpressed12 = buttonpressed12;
        this.buttonpressed20 = buttonpressed20;
        this.buttonpressed21 = buttonpressed21;
        this.buttonpressed22 = buttonpressed22;
        this.player1ax = player1ax;
        this.player1 = player1;
        this.player2 = player2;
        this.roomOwner = roomOwner;
        this.ax = ax;
        this.zero = zero;
        this.resetchecker = resetchecker;
        this.drawchecker = drawchecker;
        this.currentgamedonechecker = currentgamedonechecker;
        this.ctrflag = ctrflag;
        this.game = game;
        this.result = result;
        this.player_turn = player_turn;
    }

    public String getPlayer_turn() {
        return player_turn;
    }

    public void setPlayer_turn(String player_turn) {
        this.player_turn = player_turn;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public int getCtrflag() {
        return ctrflag;
    }

    public void setCtrflag(int ctrflag) {
        this.ctrflag = ctrflag;
    }

    public int getCurrentgamedonechecker() {
        return currentgamedonechecker;
    }

    public void setCurrentgamedonechecker(int currentgamedonechecker) {
        this.currentgamedonechecker = currentgamedonechecker;
    }

    public int getResetchecker() {
        return resetchecker;
    }

    public void setResetchecker(int resetchecker) {
        this.resetchecker = resetchecker;
    }

    public int getDrawchecker() {
        return drawchecker;
    }

    public void setDrawchecker(int drawchecker) {
        this.drawchecker = drawchecker;
    }

    public String getRoomOwner() {
        return roomOwner;
    }

    public int getAx() {
        return ax;
    }

    public void setAx(int ax) {
        this.ax = ax;
    }

    public int getZero() {
        return zero;
    }

    public void setZero(int zero) {
        this.zero = zero;
    }

    public void setRoomOwner(String roomOwner) {
        this.roomOwner = roomOwner;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getSum0() {
        return sum0;
    }

    public void setSum0(int sum0) {
        this.sum0 = sum0;
    }

    public int getSum1() {
        return sum1;
    }

    public void setSum1(int sum1) {
        this.sum1 = sum1;
    }

    public int getSum2() {
        return sum2;
    }

    public void setSum2(int sum2) {
        this.sum2 = sum2;
    }

    public int getSum3() {
        return sum3;
    }

    public void setSum3(int sum3) {
        this.sum3 = sum3;
    }

    public int getSum4() {
        return sum4;
    }

    public void setSum4(int sum4) {
        this.sum4 = sum4;
    }

    public int getSum5() {
        return sum5;
    }

    public void setSum5(int sum5) {
        this.sum5 = sum5;
    }

    public int getSum6() {
        return sum6;
    }

    public void setSum6(int sum6) {
        this.sum6 = sum6;
    }

    public int getSum7() {
        return sum7;
    }

    public void setSum7(int sum7) {
        this.sum7 = sum7;
    }

    public int getTracker00() {
        return tracker00;
    }

    public void setTracker00(int tracker00) {
        this.tracker00 = tracker00;
    }

    public int getTracker01() {
        return tracker01;
    }

    public void setTracker01(int tracker01) {
        this.tracker01 = tracker01;
    }

    public int getTracker02() {
        return tracker02;
    }

    public void setTracker02(int tracker02) {
        this.tracker02 = tracker02;
    }

    public int getTracker10() {
        return tracker10;
    }

    public void setTracker10(int tracker10) {
        this.tracker10 = tracker10;
    }

    public int getTracker11() {
        return tracker11;
    }

    public void setTracker11(int tracker11) {
        this.tracker11 = tracker11;
    }

    public int getTracker12() {
        return tracker12;
    }

    public void setTracker12(int tracker12) {
        this.tracker12 = tracker12;
    }

    public int getTracker20() {
        return tracker20;
    }

    public void setTracker20(int tracker20) {
        this.tracker20 = tracker20;
    }

    public int getTracker21() {
        return tracker21;
    }

    public void setTracker21(int tracker21) {
        this.tracker21 = tracker21;
    }

    public int getTracker22() {
        return tracker22;
    }

    public void setTracker22(int tracker22) {
        this.tracker22 = tracker22;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getButtonpressed00() {
        return buttonpressed00;
    }

    public void setButtonpressed00(int buttonpressed00) {
        this.buttonpressed00 = buttonpressed00;
    }

    public int getButtonpressed01() {
        return buttonpressed01;
    }

    public void setButtonpressed01(int buttonpressed01) {
        this.buttonpressed01 = buttonpressed01;
    }

    public int getButtonpressed02() {
        return buttonpressed02;
    }

    public void setButtonpressed02(int buttonpressed02) {
        this.buttonpressed02 = buttonpressed02;
    }

    public int getButtonpressed10() {
        return buttonpressed10;
    }

    public void setButtonpressed10(int buttonpressed10) {
        this.buttonpressed10 = buttonpressed10;
    }

    public int getButtonpressed11() {
        return buttonpressed11;
    }

    public void setButtonpressed11(int buttonpressed11) {
        this.buttonpressed11 = buttonpressed11;
    }

    public int getButtonpressed12() {
        return buttonpressed12;
    }

    public void setButtonpressed12(int buttonpressed12) {
        this.buttonpressed12 = buttonpressed12;
    }

    public int getButtonpressed20() {
        return buttonpressed20;
    }

    public void setButtonpressed20(int buttonpressed20) {
        this.buttonpressed20 = buttonpressed20;
    }

    public int getButtonpressed21() {
        return buttonpressed21;
    }

    public void setButtonpressed21(int buttonpressed21) {
        this.buttonpressed21 = buttonpressed21;
    }

    public int getButtonpressed22() {
        return buttonpressed22;
    }

    public void setButtonpressed22(int buttonpressed22) {
        this.buttonpressed22 = buttonpressed22;
    }

    public boolean isPlayer1ax() {
        return player1ax;
    }

    public void setPlayer1ax(boolean player1ax) {
        this.player1ax = player1ax;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "TicTacToeModel{" +
                "flag=" + flag +
                ", win=" + win +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", player1ax=" + player1ax +
                ", player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", roomOwner='" + roomOwner + '\'' +
                ", ax=" + ax +
                ", zero=" + zero +
                ", resetchecker=" + resetchecker +
                ", drawchecker=" + drawchecker +
                ", currentgamedonechecker=" + currentgamedonechecker +
                ", ctrflag=" + ctrflag +
                ", sum0=" + sum0 +
                ", sum1=" + sum1 +
                ", sum2=" + sum2 +
                ", sum3=" + sum3 +
                ", sum4=" + sum4 +
                ", sum5=" + sum5 +
                ", sum6=" + sum6 +
                ", sum7=" + sum7 +
                ", tracker00=" + tracker00 +
                ", tracker01=" + tracker01 +
                ", tracker02=" + tracker02 +
                ", tracker10=" + tracker10 +
                ", tracker11=" + tracker11 +
                ", tracker12=" + tracker12 +
                ", tracker20=" + tracker20 +
                ", tracker21=" + tracker21 +
                ", tracker22=" + tracker22 +
                ", buttonpressed00=" + buttonpressed00 +
                ", buttonpressed01=" + buttonpressed01 +
                ", buttonpressed02=" + buttonpressed02 +
                ", buttonpressed10=" + buttonpressed10 +
                ", buttonpressed11=" + buttonpressed11 +
                ", buttonpressed12=" + buttonpressed12 +
                ", buttonpressed20=" + buttonpressed20 +
                ", buttonpressed21=" + buttonpressed21 +
                ", buttonpressed22=" + buttonpressed22 +
                '}';
    }
}
