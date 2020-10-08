/**
 * 
 */
package org.latamjugs.mastering.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author ecabrerar
 * @since Oct 7, 2020
 */
public class SimpleDateFormatThreadUnsafetyExample {
	private static final Logger logger = Logger.getLogger(SimpleDateFormatThreadUnsafetyExample.class.getName());


	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static void main(String[] args) {
        String dateStr = "2018-06-22T10:00:00";

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                parseDate(dateStr);
            }
        };

        for(int i = 0; i < 100; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();
    }

    private static void parseDate(String dateStr) {
        try {
            Date date = simpleDateFormat.parse(dateStr);
            logger.info("Successfully Parsed Date " .concat(date.toString()));
        } catch (ParseException e) {
        	logger.info("ParseError " .concat( e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
