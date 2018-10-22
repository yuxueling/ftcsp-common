package com.sxyht.common.utils.ipAddress;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * project test script
 * 
 * @author chenxin<chenxin619315@gmail.com>
*/
public class IpAddressUtils {
	private static String[] argv=new String[] {"./data/ip2region.db"};
    public static String queryAddressByIp(String ip) {
    	if ( argv.length == 0 ) {
            System.out.println("| Usage: java -jar ip2region-{version}.jar [ip2region db file]");
            return "-1";
        }
        File file = new File(argv[0]);
        if ( file.exists() == false ) {
            System.out.println("Error: Invalid ip2region.db file");
            return "-1";
        }
        int algorithm = DbSearcher.BTREE_ALGORITHM;
        String algoName = "B-tree";
        if ( argv.length > 1 ) {
            if ( argv[1].equalsIgnoreCase("binary")) {
                algoName  = "Binary"; 
                algorithm = DbSearcher.BINARY_ALGORITHM;
            } else if ( argv[1].equalsIgnoreCase("memory") ) {
                algoName  = "Memory";
                algorithm = DbSearcher.MEMORY_ALGORITYM;
            }
        }
        try {
            System.out.println("initializing "+algoName+" ... ");
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, argv[0]);
            //define the method
            Method method = null;
            switch ( algorithm ){
            case DbSearcher.BTREE_ALGORITHM:
                method = searcher.getClass().getMethod("btreeSearch", String.class);
                break;
            case DbSearcher.BINARY_ALGORITHM:
                method = searcher.getClass().getMethod("binarySearch", String.class);
                break;
            case DbSearcher.MEMORY_ALGORITYM:
                method = searcher.getClass().getMethod("memorySearch", String.class);
                break;
            }
            System.out.println("+----------------------------------+");
            System.out.println("| ip2region test shell             |");
            System.out.println("| Author: chenxin619315@gmail.com  |");
            System.out.println("| Type 'quit' to exit program      |");
            System.out.println("+----------------------------------+");
            double sTime = 0, cTime = 0;
            String line = null;
            DataBlock dataBlock = null;
            line = ip;
            if ( line.length() < 2 ) {
            }
            if ( line.equalsIgnoreCase("quit") ) {
            }
            if ( Util.isIpAddress(line) == false ) {
                System.out.println("Error: Invalid ip address");
            }
            
            sTime = System.nanoTime();
            dataBlock = (DataBlock) method.invoke(searcher, line);
            cTime = (System.nanoTime() - sTime) / 1000000;
            System.out.printf("%s in %.5f millseconds\n", dataBlock, cTime);
            searcher.close();
            return dataBlock.getRegion();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DbMakerConfigException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	return "-1";
    }
}
