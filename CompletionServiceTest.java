import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.IOUtils;


/**
 * https://dzone.com/articles/executorcompletionservice
 *  ExecutorCompletionService wrapper class tries to address one of the biggest deficiencies of Future<T> type
 *   - no support for callbacks or any event-driven behaviour whatsoever. 
 * @author debojyoti.sarkar
 *
 */
public class CompletionServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        final List<String> topSites = Arrays.asList(
"www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com",
        "www.wikipedia.org", "www.baidu.com", "www.microsoft.com", "www.qq.com",
        "www.bing.com", "www.ask.com", "www.adobe.com", "www.taobao.com",
        "www.youku.com", "www.soso.com", "www.wordpress.com", "www.sohu.com",
        "www.windows.com", "www.163.com", "www.tudou.com", "www.amazon.com"
);
 long start2 = System.currentTimeMillis();       
 long start = System.nanoTime();
 final ExecutorService pool = Executors.newFixedThreadPool(5);
 List<Future<String>> contentsFutures = new ArrayList<>(topSites.size());
 for (final String site : topSites) {
     final Future<String> contentFuture = pool.submit(new Callable<String>() {
        @Override
        public String call() throws Exception {
            return site+"1";
            		//IOUtils.toString(new URL("http://" + site), StandardCharsets.UTF_8);
        }
     });
    contentsFutures.add(contentFuture);
   }
System.out.println("TimeInNanoTaken="+(System.nanoTime() - start)); 
System.out.println("TimeInMillTaken="+(System.currentTimeMillis() - start2)); 
 
	}

}
