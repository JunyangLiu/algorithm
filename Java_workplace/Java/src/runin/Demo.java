package runin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ietf.jgss.GSSManager;
import org.junit.Test;




public class Demo {

public  File creatRecordFile() throws IOException{
	 File file=new File("jun.runin");
	 RandomAccessFile raf=new RandomAccessFile(file, "rw");
//	 byte 类型的取值范围是-128～127
	 byte[] head={0x23,0x33,0x00 ,0x19 ,0x40 ,0x37 ,0x57 ,  0x19 ,0x0f ,0x39 ,0x72 ,0x47 ,0x40 ,0x5e ,0x54 ,0x70 ,0x38 ,0x55 ,0x69 ,0x4a ,0x58 ,0x58 ,0x5c , 0x7b ,0x00 ,0x00 ,0x00 ,0x00 ,0x00};
	 raf.write(head);
	raf.close();
	 return file;
	 
}
public  byte[] getFileData(File file) throws IOException{
    RandomAccessFile raf=new RandomAccessFile(file, "rw");   
    byte[] data=new byte[(int)raf.length()];
    raf.read(data);
    for(int i=0;i<data.length;i++){
    	System.out.print(Integer.toHexString(data[i])+",");
    }
    raf.close();
	return data;
//}
//public getPoints(byte[] data){
//	int count=data[4];//点得数据长度
//	for(int i=4;i<data.length;i+=3){
//		//path.addPon
//	}
//	
}

@Test
public void test() throws IOException{
//		getFileData(creatRecordFile());
	long currentTime = System.currentTimeMillis();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
	Date date = new Date(currentTime);
	System.out.println(formatter.format(date));
}  
}
