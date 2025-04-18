
// Package: synergy.java-client

import functions.ConnectSQL;

public class Ghost {
    public static void main(String[] args) {
        // SquareTest squareTest = new SquareTest(10);
        // MultiFnc multiFnc = new MultiFnc(10, 20, "add");
        // multiFnc.connect();
        // squareTest.connect();
        ConnectSQL sql = new ConnectSQL();
        System.out.println("Connecting to SQL database........... ");
        sql.getConnection();
        System.out.println("Finalized........... ");

    }

}