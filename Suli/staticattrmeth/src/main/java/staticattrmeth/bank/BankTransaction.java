package staticattrmeth.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankTransaction {

    private final long minValueToSet = 1L;
    private final long maxValueToSet = 10000000L;

    private long trxValue;
    private static long currentMinValue = Long.MAX_VALUE;
    private static long currentMaxValue = Long.MIN_VALUE;
    private static BigDecimal sumOfTrxs = new BigDecimal("0");
    private static List<Long> transactionList = new ArrayList<>();




    public static void initTheDay(){


    }
    public static BigDecimal averageOfTransaction(){

    }
    public static long getCurrentMinValue(){

    }
    public static long getCurrentMaxValue(){

    }
    public static BigDecimal getSumOfTrxs(){

    }



}
