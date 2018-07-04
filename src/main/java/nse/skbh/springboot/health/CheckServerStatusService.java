package nse.skbh.springboot.health;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckServerStatusService {


	public static Map<Long, String> getJVMMemoryDetail(){
		    long MEGABYTE = 1024L * 1024L;
		    Runtime runtime = Runtime.getRuntime();
		 	//Get the jvm heap size.
	        long totalHeapSize = (Runtime.getRuntime().totalMemory())/ MEGABYTE;
	        long usedHeapSizeMemory=(runtime.totalMemory() - runtime.freeMemory()) / MEGABYTE;
	        long freeHeapSizeMemory=runtime.freeMemory() / MEGABYTE;
	        //get Maximum available memory
	        long maximumHeapSizememory=runtime.maxMemory() / MEGABYTE;
	        Map<Long,String>  heapSizeMap=new LinkedHashMap<Long,String>();
	        heapSizeMap.put(usedHeapSizeMemory, "Used Heap Size Memory in JVM");
	        heapSizeMap.put(freeHeapSizeMemory, "Free Heap Size Memory in JVM");
	        heapSizeMap.put(totalHeapSize, "Total Heap Memory in JVM");
	        heapSizeMap.put(maximumHeapSizememory, "Maximum Heap Size Memory in JVM");
	            
	return heapSizeMap;
		
	}
	
	
	public static List<Long> getSimpleJVMMemoryDetail(){
		long MEGABYTE = 1024L * 1024L;
		 Runtime runtime = Runtime.getRuntime();
		 	//Get the jvm heap size.
	        long totalHeapSize = (Runtime.getRuntime().totalMemory())/ MEGABYTE;
	        long usedHeapSizeMemory=(runtime.totalMemory() - runtime.freeMemory()) / MEGABYTE;
	        long freeHeapSizeMemory=runtime.freeMemory() / MEGABYTE;
	        //get Maximum available memory
	        long maximumHeapSizememory=runtime.maxMemory() / MEGABYTE;
	        List<Long> list=new ArrayList<Long>();	        
	        list.add(usedHeapSizeMemory);
	        list.add(freeHeapSizeMemory);
	        list.add(totalHeapSize);
	        list.add(maximumHeapSizememory);
		return list;
		
	}
	
	public static boolean isDatabaseOnline(String address, int port) {
	    boolean result;

	    try {
	        Socket socket = new Socket(address, port);
	        socket.close();

	        result = true;
	    } catch (IOException e) {
	        result = false;
	    }

	    return result;
	}
	
	public static boolean hostAvailabilityCheck(String address, int port) {
	    boolean result;

	    try {
	        Socket socket = new Socket(address, port);
	        socket.close();
	        result = true;
	    } catch (IOException e) {
	        result = false;
	    }

	    return result;
	}
	
}
