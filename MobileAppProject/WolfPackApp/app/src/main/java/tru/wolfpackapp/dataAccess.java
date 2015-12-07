package tru.wolfpackapp;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class dataAccess {

    private String filename;
    private InputStream fIn;
    private InputStreamReader isr;
    private BufferedReader bufferedReader;

    public dataAccess (){
        Log.d("testset", "Default constructor not implemented.");
    }
    public dataAccess (Context con, String fileToAccess){


        filename = fileToAccess;
        try{
            fIn = con.getAssets().open(fileToAccess);
            isr = new InputStreamReader(fIn);
            bufferedReader = new BufferedReader(isr);
        }
        catch(Exception e){
            Log.d("testset", "Exception: " + e.toString());
        }
    }
    public String getFilename(){
        return filename;
    }
    public void setFilename(String newFileName){
        filename = newFileName;
    }

    public String readLine(){
        String line = null;
        try{
            line = bufferedReader.readLine();
        }
        catch(Exception e){
            Log.d("testset", "Exception: " + e.toString());
        }
        return line;
    }

    public void close(){
        try{
            isr.close();
        }
        catch(Exception e){
            Log.d("testset", "Exception: " + e.toString());
        }
    }

}
