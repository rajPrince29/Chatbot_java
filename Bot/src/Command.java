import java.util.Scanner;

public class Command {
@SuppressWarnings("unused")
static void handle(String str)
{
	if(str.equalsIgnoreCase("start command"))
		{
			try{
			Process p;
			p = Runtime.getRuntime().exec("cmd /c start cmd");
			Bot.textToSpeech("Affirmative", "kevin16");
			}catch(Exception er)
			{}
		}if (str.equalsIgnoreCase("close command"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		if (str.equalsIgnoreCase("Power Options"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c powercfg.cpl");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		if (str.equalsIgnoreCase("open Bluetooth"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c fsquirt");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		if (str.equalsIgnoreCase("start photoshop"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start photoshop");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		if (str.equalsIgnoreCase("start calculator"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start calc");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		if (str.equalsIgnoreCase("Windows Security Center"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c wscui.cpl");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		else if (str.equalsIgnoreCase("start Player"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start wmplayer");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		else  if (str.equalsIgnoreCase("open Programs"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start appwiz.cpl");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	    }
		 else if (str.equalsIgnoreCase("start Control"))
		    {
		        try{
		        Process p;
		        p = Runtime.getRuntime().exec("cmd /c control");
		        Bot.textToSpeech("Affirmative", "kevin16");
		        }catch(Exception ae){}
		    }
		else if(str.equalsIgnoreCase("open paint"))
		{	 try{
			        Process p;
			        p = Runtime.getRuntime().exec("cmd /c start mspaint");
			        Bot.textToSpeech("Affirmative", "kevin16");
			        }catch(Exception ae){}
		}
		else if(str.equalsIgnoreCase("close paint"))
		{	 try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start taskkill /im mspaint.exe /f");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
		}
		else if(str.equalsIgnoreCase("close calculator"))
		{	 try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start taskkill /im calc.exe /f");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
}
		else if (str.equalsIgnoreCase("open Browser"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start iexplore.exe");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }else if (str.equalsIgnoreCase("close Browser"))
		    {
		        try{
		        Process p;
		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im iexplore.exe /f");
		        Bot.textToSpeech("Affirmative", "kevin16");
		        }catch(Exception ae){}
		     }
		
		else if(str.equalsIgnoreCase("strat task manager"))
			{	 try{
		        Process p;
		        p = Runtime.getRuntime().exec("cmd /c start taskmgr.exe");
		        Bot.textToSpeech("Affirmative", "kevin16");
		        }catch(Exception ae){}
			}
		else if(str.equalsIgnoreCase("open Adobe"))
		{	 try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start acrord32.exe");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
		}
		else if(str.equalsIgnoreCase("site facebook"))
		{	 try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start iexplore www.facebook.com");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
		}
		else if(str.equalsIgnoreCase("site google"))
		{	 try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start iexplore www.google.com");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
		}
		else if(str.equalsIgnoreCase("site mail"))
		{	 try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start iexplore https://mail.google.com");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
		}
	     else if(str.equalsIgnoreCase("close task manager"))
			{	 try{
		        Process p;
		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im taskmgr.exe /f");
		        Bot.textToSpeech("Affirmative", "kevin16");
		        }catch(Exception ae){}
	}
		else if (str.equalsIgnoreCase("open notepad")||str.equalsIgnoreCase("open pad"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start notepad");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("close pad")||str.equalsIgnoreCase("close notepad"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start taskkill /im notepad.exe /f");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("open word"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start winword");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("close word"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start taskkill /im winword.exe /f");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("start wordpad"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c  write");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("stop word pad"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c  start taskkill /im wordpad.exe /f");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		
		else if (str.equalsIgnoreCase("start Excel"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start excel");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }else if (str.equalsIgnoreCase("stop Excel"))
		    {
		        try{
		        Process p;
		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im excel.exe /f");
		        Bot.textToSpeech("Affirmative", "kevin16");
		        }catch(Exception ae){}
		     }
		else if (str.equalsIgnoreCase("start firewall"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start firewall.cpl");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("close firewall"))
	    {
	        try{
	        Process p;
	        String status = "status eq Windows Firewall";
	        p = Runtime.getRuntime().exec("cmd /c taskkill /f /fi " +status );
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("start nero"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start nero");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("open Access"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start msaccess");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("close access"))
	    {
	        try{
	        Process p;
	        p = Runtime.getRuntime().exec("cmd /c start taskkill /im msaccess.exe /f");
	        Bot.textToSpeech("Affirmative", "kevin16");
	        }catch(Exception ae){}
	     }
		else if (str.equalsIgnoreCase("Device Manager"))
		    {
		        try{
		        Process p;
		        p = Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
		        Bot.textToSpeech("Affirmative", "kevin16");
		        }catch(Exception ae){}
		     }
	
	    }
 static String substringAfter(String str, String separator) {
    if (isEmpty(str)) {
        return str;
    }
    if (separator == null) {
        return "";
    }
    int pos = str.indexOf(separator);
    if (pos == -1) {
        return "";
    }
    return str.substring(pos + separator.length());
}
 public static boolean isEmpty(String str) {
     return str == null || str.length() == 0;
 }
 public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	handle(s);
}
}