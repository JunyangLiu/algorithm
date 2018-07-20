package runin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PathData {
	private File mFile;
	private RandomAccessFile raf;
	
	public PathData() throws IOException {
		mFile=new File("record.ruin");
		raf=new RandomAccessFile(mFile, "rw");
		//写入文件头
		byte[] head={0x23,0x33};
		raf.write(head);
	}
	/*
	 * 参数
	 */
	public void addPoint(double lon,double lat,long time){
		
	}
}
