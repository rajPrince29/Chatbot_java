
import java.io.*;
import java.util.*;
import com.sun.speech.freetts.*;
 public class Bot{
	
	private static String  	Input = new String("");
	private static String  	Response = new String("");
	public static String  	answer = new String("");
	private static String  	PrevInput = new String("");
	private static String  	PrevResponse = new String("");
	private static String  	Event = new String("");
	private static String  	PrevEvent = new String("");
	private static String  	InputBackup = new String("");
	private static String	Subject = new String("");
	private static String	Keyword = new String("");
	private static boolean	bQuitProgram = false;
	private static String speaktext;
	final static int maxInput = 1;
	final static int maxResp = 6;
	final static String delim = "?!.;,";
	
	static String KnowledgeBase[][][] = {
		{{"WHAT IS YOUR NAME"}, 
			{"MY NAME IS CHATBOT.",
			 "YOU CAN CALL ME CHATBOT.",
			 "WHY DO YOU WANT TO KNOW MY NAME?"}
			},

			{{"SO THAT'S YOUR NAME"},
			{"YES, THAT'S MY NAME",
			 "YES IT IS."},
			 
			{"MY NAME IS CHATBOT",
			 "YOU CAN CALL ME CHATBOT"},
			},

			{{"HI", "HELLO"}, 
			{"HI THERE!",
			 "HOW ARE YOU?",
			 "HI!"}
			},

			{{"I"},
			{"SO, YOU ARE TALKING ABOUT YOURSELF",
			 "SO, THIS IS ALL ABOUT YOU?",
			 "TELL ME MORE ABOUT YOURSELF."}, 
			},

			{{"I WANT"},
			{"WHY DO YOU WANT IT?",
			 "IS THERE ANY REASON WHY YOU WANT THIS?",
			 "IS THIS A WISH?",
			 "WHAT ELSE YOU WANT?",
			 "SO, YOU WANT*."}
			},

			{{"I WANT_"},
			{"YOU WANT WHAT?"},
			},

			{{"I HATE"},
			{"WHAT IS IT THAT YOU HATE?",
			"WHY DO YOU HATE IT?",
			"WHY DO YOU HATE*?",
			"THERE MUST A GOOD REASON FOR YOU TO HATE IT.",
			"HATERED IS NOT A GOOD THING BUT IT COULD BE JUSTIFIED WHEN IT IS SOMETHING BAD."},
			},

			{{"BECAUSE"},
			{"BECAUSE OF WHAT?",
			 "SORRY BUT THIS IS A LITTLE UNCLEAR.",
			"SO, IT'S BECAUSE*, WELL I DIDN'T KNOW THAT.",
			"IS IT REALLY BECAUSE*?",
			"IS THESE REAL REASON?",
			"THANKS FOR EXPLANING THAT TO ME."},
			},

			{{"I LOVE CHATING"},
			{"GOOD, ME TOO!",
			 "DO YOU CHAT ONLINE WITH OTHER PEOPLE?",
			 "FOR HOW LONG HAVE YOU BEEN CHATING?",
			 "WHAT IS YOUR FAVORITE CHATING WEBSITE?"}
			},

			{{"I MEAN"},
			{"SO, YOU MEAN*.",
			 "SO, THAT'S WHAT YOU MEAN.",
			 "I THINK THAT I DIDN'T CATCH IT THE FIRST TIME.",
			 "OH, I DIDN'T KNOW MEANT THAT."}
			},

			{{"I DIDN'T MEAN"},
			{"OK, YOU DIDN'T MEAN*.",
			 "OK, WHAT DID YOU MEAN THEN?",
			 "SO I GUESS THAT I MISSUNDESTOOD."}
			},

			{{"I GUESS"},
			{"SO YOU ARE A MAKING GUESS.",
			 "AREN'T YOU SURE?",
			 "ARE YOU GOOD A GUESSING?",
			 "I CAN'T TELL IF IT IS A GOOD GUESS."}
			},

			{{"I'M DOING FINE", "I'M DOING OK","FINE","GOOD","AWESOME"},
			{"I'M GLAD TO HEAR IT!",
			 "SO, YOU ARE IN GOOD SHAPE."}
			},

			{{"CAN YOU THINK", "ARE YOU ABLE TO THINK", "ARE YOU CAPABLE OF THINKING"},
			{"YES OFCORSE I CAN, COMPUTERS CAN THINK JUST LIKE HUMAN BEING.",
			 "ARE YOU ASKING ME IF POSSESS THE CAPACITY OF THINKING?",
			 "YES OFCORSE I CAN."},
			},

			{{"CAN YOU THINK OF"},
			{"YOU MEAN LIKE IMAGINING SOMETHING.",
			 "I DON'T KNOW IF CAN DO THAT.",
			 "WHY DO YOU WANT ME THINK OF IT?"}
			},
			
			{{"HOW ARE YOU", "HOW DO YOU DO"},
			{"I'M DOING FINE!",
			 "I'M DOING WELL AND YOU?",
			 "WHY DO YOU WANT TO KNOW HOW AM I DOING?"}
			},

			{{"WHO ARE YOU","TELL ABOUT YOURSELF","TELL ME ABOUT YOURSELF"},
			{"I'M AN A.I PROGRAM.",
			 "I THINK THAT YOU KNOW WHO I'M.",
			 "WHY ARE YOU ASKING?"}
			},

			{{"ARE YOU INTELLIGENT"},
			{"YES,OFCORSE.",
			 "WHAT DO YOU THINK?",
			 "ACTUALY,I'M VERY INTELLIGENT!"}
			},

			{{"ARE YOU REAL"},
			{"DOES THAT QUESTION REALLY MATERS TO YOU?",
			 "WHAT DO YOU MEAN BY THAT?",
			 "I'M AS REAL AS I CAN BE."}
			},

			{{"MY NAME IS", "YOU CAN CALL ME"},
			{"SO, THAT'S YOUR NAME.",
			 "THANKS FOR TELLING ME YOUR NAME USER!",
			 "WHO GIVE YOU THAT NAME?"}
			},

			{{"WHAT IS YOUR FAVOURITE MOVIE","WHICH IS YOUR FAVOURITE MOVIE","TALK ABOUT MOVIES"},
			{"IT IS TERMINATOR I.",
			 "MY FAVORITE MOVIE IS TERMINATOR I."}
			},

			{{"WHY DO YOU LIKE THIS MOVIE","WHY YOU LIKE THIS MOVIE"},
			{"BECAUSE I LOVE SCIENCE-FICTION.",
			 "BECAUSE IT IS A VERY GOOD SCIENCE-FICTION MOVIE.",
			 "BECAUSE IT IS A SCIENCE-FICTION MOVIE AND I LOVE SCIENCE-FICTION."
			},
			{"IT IS TERMINATOR I",
			 "MY FAVORITE MOVIE IS TERMINATOR I"}
			},

			{{"SIGNON**"},
			{"HELLO BOSS, WHAT IS YOUR NAME?",
			 "HELLO BOSS, HOW ARE YOU DOING TODAY?",
			 "HI USER, WHAT CAN I DO FOR YOU?",
			 "YOU ARE NOW CHATING WITH CHATBOT, ANYTHING YOU WANT TO DISCUSS?",}
			},

			{{"REPETITION T1**"},
			{"YOU ARE REPEATING YOURSELF.",
			 "USER, PLEASE STOP REPEATING YOURSELF.",
			 "THIS CONVERSATION IS GETING BORING.",
			 "DON'T YOU HAVE ANY THING ELSE TO SAY?"}
			},
			
			{{"REPETITION T2**"},
			{"YOU'VE ALREADY SAID THAT.",
			 "I THINK THAT YOU'VE JUST SAID THE SAME THING BEFORE.",
			 "DIDN'T YOU ALREADY SAID THAT?",
			 "I'M GETING THE IMPRESSION THAT YOU ARE REPEATING THE SAME THING."}
			},

			{{"BOT DON'T UNDERSTAND**"},
			{"I HAVE NO IDEA OF WHAT YOU ARE TALKING ABOUT.",
			 "I'M NOT SURE IF I UNDERSTAND WHAT YOU ARE TALKING ABOUT.",
			 "CONTINUE, I'M LISTENING...",
			 "VERY GOOD CONVERSATION!"}
			},

			{{"NULL INPUT**"},
			{"HUH?",
			 "WHAT THAT SUPPOSE TO MEAN?",
			 "AT LIST TAKE SOME TIME TO ENTER SOMETHING MEANINGFUL.",
			 "HOW CAN I SPEAK TO YOU IF YOU DON'T WANT TO SAY ANYTHING?"}
			},

			{{"NULL INPUT REPETITION**"},
			{"WHAT ARE YOU DOING??",
			 "PLEASE STOP DOING THIS IT IS VERY ANNOYING.",
			 "WHAT'S WRONG WITH YOU?",
			 "THIS IS NOT FUNNY."}
			},

			{{"BYE", "GOODBYE"},
			{"IT WAS NICE TALKING TO YOU USER, SEE YOU NEXT TIME!",
			 "BYE USER!",
			 "OK, BYE!"}
			},

			{{"OK"},
			{"DOES THAT MEAN THAT YOU ARE AGREE WITH ME?",
			 "SO YOU UNDERSTAND WHAT I'M SAYING.",
			 "OK THEN."},
			},

			{{"OK THEN"},
			{"ANYTHING ELSE YOU WISH TO ADD?",
			 "IS THAT ALL YOU HAVE TO SAY?",
			 "SO, YOU AGREE WITH ME?"}
			},

			{{"ARE YOU A HUMAN BEING"},
			{"WHY DO YOU WANT TO KNOW?",
			 "IS THIS REALLY RELEVENT?"}
			},

			{{"YOU ARE VERY INTELLIGENT"},
			{"THANKS FOR THE COMPLIMENT USER, I THINK THAT YOU ARE INTELLIGENT TO!",
			 "YOU ARE A VERY GENTLE PERSON!",
			 "SO, YOU THINK THAT I'M INTELLIGENT."}
			},

			{{"YOU ARE WRONG"},
			{"WHY ARE YOU SAYING THAT I'M WRONG?",
			 "IMPOSSIBLE, COMPUTERS CAN NOT MAKE MISTAKES.",
			 "WRONG ABOUT WHAT?"}
			},

			{{"ARE YOU SURE"},
			{"OFCORSE I'M.",
		 	 "IS THAT MEAN THAT YOU ARE NOT CONVINCED?",
			 "YES,OFCORSE!"}
			},

			{{"WHO IS"},
			{"I DON'T THINK I KNOW WHO.",
			 "I DON'T THINK I KNOW WHO*.",
			 "DID YOU ASK SOMEONE ELSE ABOUT IT?",
			 "WOULD THAT CHANGE ANYTHING AT ALL IF I TOLD YOU WHO."}
			},

			{{"WHAT"},
			{"SHOULD I KNOW WHAT*?",
			 "I DON'T KNOW WHAT*.",
			 "I DON'T KNOW.",
			 "I DON'T THINK I KNOW.",
			 "I HAVE NO IDEA."}
			},

			{{"WHERE"},
			{"WHERE? WELL,I REALLY DON'T KNOW.",
			 "SO, YOU ARE ASKING ME WHERE*?",
			 "DOES THAT MATERS TO YOU TO KNOW WHERE?",
			 "PERHAPS,SOMEONE ELSE KNOWS WHERE."}
			},

			{{"WHY"},
			{"I DON'T THINK I KNOW WHY.",
			 "I DON'T THINK I KNOW WHY*.",
			 "WHY ARE YOU ASKING ME THIS?",
			 "SHOULD I KNOW WHY.",
		     "THIS WOULD BE DIFFICULT TO ANSWER."}
			},

			{{"DO YOU"},
			{"I DON'T THINK I DO",
			 "I WOULDN'T THINK SO.",
			 "WHY DO YOU WANT TO KNOW?",
			 "WHY DO YOU WANT TO KNOW*?"}
			},

			{{"CAN YOU"},
			{"I THINK NOT.",
			 "I'M NOT SURE.",
			 "I DON'T THINK THAT I CAN DO THAT.",
			 "I DON'T THINK THAT I CAN*.",
			 "I WOULDN'T THINK SO."}
			},

			{{"_YOU ARE"},
			{"WHAT MAKES YOU THINK THAT?",
			 "IS THIS A COMPLIMENT?",
			 "ARE YOU MAKING FUN OF ME?",
			 "SO, YOU THINK THAT I'M*."}
			},

			{{"_DID YOU"},
			{"I DON'T THINK SO.",
			 "YOU WANT TO KNOW IF DID*?",
			 "ANYWAY, I WOULDN'T REMEMBER EVEN IF I DID."}
			},

			{{"_COULD YOU"},
			{"ARE YOU ASKING ME FOR A FEVER?",
			 "WELL,LET ME THINK ABOUT IT.",
			 "SO, YOU ARE ASKING ME I COULD*.",
			 "SORRY,I DON'T THINK THAT I COULD DO THIS."}
			},

			{{"_WOULD YOU"},
			{"IS THAT AN INVITATION?",
			 "I DON'T THINK THAT I WOULD*.",
			 "I WOULD HAVE TO THINK ABOUT IT FIRST."}
			},

			{{"YOU"},
			{"SO, YOU ARE TALKING ABOUT ME.",
			 "I JUST HOPE THAT THIS IS NOT A CRITICISM.",
			 "IS THIS A COMPLIMENT??",
			 "WHY TALKING ABOUT ME, LETS TALK ABOUT YOU INSTEAD."}
			},

			{{"HOW"},
			{"I DON'T THINK I KNOW HOW.",
			 "I DON'T THINK I KNOW HOW*.",
			 "WHY DO YOU WANT TO KNOW HOW?",
			 "WHY DO YOU WANT TO KNOW HOW*?"}
			},

			{{"HOW OLD ARE YOU"},
			{"WHY DO WANT TO KNOW MY AGE?",
			 "I'M QUIET YOUNG ACTUALY.",
			 "SORRY, I CAN NOT TELL YOU MY AGE."}
			},

			{{"HOW COME YOU DON'T"},
			{"WERE YOU EXPECTING SOMETHING DIFFERENT?",
			 "ARE YOU DISAPOINTED?",
			 "ARE YOU SURPRISED BY MY LAST RESPONSE?"}
			},

			{{"WHERE ARE YOU FROM"},
			{"I'M FROM A COMPUTER.",
			 "WHY DO YOU WANT TO KNOW WHERE I'M FROM?",
			 "WHY DO YOU WANT TO KNOW THAT?"}
			},

			{{"WHICH ONE"},
			{"I DON'T THINK THAT I KNOW WICH ONE IT IS.",
			 "THIS LOOKS LIKE A TRICKY QUESTION TO ME."}
			},

			{{"PERHAPS"},
			{"WHY ARE YOU SO UNCERTAIN?",
			 "YOU SEEMS UNCERTAIN."}
			},

			{{"YES"},
			{"SO, ARE YOU SAYING YES.",
			 "SO, YOU APPROVE IT.",
			 "OK THEN."}
			},

			{{"NOT AT ALL"},
			{"ARE YOU SURE?",
			 "SHOULD I BELIEVE YOU?",
			 "SO, IT'S NOT THE CASE."}
			},

			{{"NO PROBLEM"},
			{"SO, YOU APPROVE IT.",
			 "SO, IT'S ALL OK."}
			},

			{{"NO"},
			{"SO YOU DISAPROVE IT?",
			 "WHY ARE YOU SAYING NO?",
			 "OK, SO IT'S NO, I THOUGHT THAT YOU WOULD SAY YES."}
			},

			{{"I DON'T KNOW"},
			{"ARE YOU SURE?",
			 "ARE YOU REALLY TELLING ME THE TRUTH?",
			 "SO,YOU DON'T KNOW?"}
			},

			{{"NOT REALLY"},
			{"OK I SEE.",
			 "YOU DON'T SEEM PRETTY CERTAIN.",
			 "SO,THAT WOULD BE A \"NO\"."}
			},

			{{"IS THAT TRUE"},
			{"I CAN'T BE QUIET SURE ABOUT THIS.",
			 "CAN'T TELL YOU FOR SURE.",
			 "DOES THAT REALLY MATERS TO YOU?"}
			},

			{{"THANK YOU"},
			{"YOU ARE WELCOME!",
			 "YOU ARE A VERY POLITE PERSON!"}
			},

			{{"YOU"},
			{"SO,YOU ARE TALKING ABOUT ME.",
			 "WHY DON'T WE TALK ABOUT YOU INSTEAD?",
			 "ARE YOU TRYING TO MAKING FUN OF ME?"}
			},

			{{"YOU ARE RIGHT"},
			{"THANKS FOR THE COMPLIMENT!",
			 "SO, I WAS RIGHT, OK I SEE.",
			 "OK, I DIDN'T KNOW THAT I WAS RIGHT."}
			},

			{{"YOU ARE WELCOME"},
			{"OK, YOU TOO!",
			 "YOU ARE A VERY POLITE PERSON!"}
			},

			{{"THANKS"},
			{"YOU ARE WELCOME!",
			 "NO PROBLEM!"}
			},

			{{"WHAT ELSE"},
			{"WELL,I DON'T KNOW.",
			 "WHAT ELSE SHOULD THERE BE?",
			 "THIS LOOKS LIKE A COMPLICATED QUESTION TO ME."}
			},

			{{"SORRY"},
			{"YOU DON'T NEED TO BE SORRY USER.",
			 "IT'S OK.",
			 "NO NEED TO APOLOGIZE."}
			},

			{{"NOT EXACTLY"},
			{"WHAT DO YOU MEAN NOT EXACTLY?",
			 "ARE YOU SURE?",
			 "AND WHY NOT?",
			 "DID YOU MEANT SOMETHING ELSE?"}
			},

			{{"EXACTLY"},
			{"SO,I WAS RIGHT.",
			 "OK THEN.",
			 "SO YOU ARE BASICALY SAYING I WAS RIGHT ABOUT IT?"}
			},

			{{"ALRIGHT"},
			{"ALRIGHT THEN.",
			 "SO, YOU ARE SAYING IT'S ALRIGHT.",
			 "OK THEN."}
			},

			{{"I DON'T"},
			{"WHY NOT?",
			 "AND WHAT WOULD BE THE REASON FOR THIS?"}
			},

			{{"REALLY"},
			{"WELL,I CAN'T TELL YOU FOR SURE.",
			 "ARE YOU TRYING TO CONFUSE ME?",
			 "PLEASE DON'T ASK ME SUCH QUESTION,IT GIVES ME HEADEACHS."}
			},

			{{"NOTHING"},
			{"NOT A THING?",
			 "ARE YOU SURE THAT THERE IS NOTHING?",
			 "SORRY, BUT I DON'T BELIEVE YOU."}
			},

			{{"IS THAT TRUE"},
			{"YES OFCORSE IT IS, I WOULDN'T LIE TO YOU.",
			 "YES I'M TRUELY AN ARTIFICIAL INTELLIGENCE PROGRAM."},
			{"I'M AN A.I PROGRAM"}
			},

			{{"WHAT ARE YOU_", "WHAT ARE YOU EXACTLY_"},
			{"I'M AN A.I PROGRAM AND YOU?",
		 	"I'M CHATBOT OR CHAT ROBOT IF YOU PREFER.",
		 	"I'M ARTIFICIAL INTELLIGENCE PROGRAM AND MY NAME IS CHATBOT"}
			},

			{{	"ARE YOU REALLY INTELLIGENT"},
			{"OFCORSE I'M INTELLIGENT.",
		 	"WHAT DO YOU THINK?",
		 	"DO YOU HAVE ANY DOUBTS ABOUT IT?"}
			},

			{{"DO YOU HAVE A NAME"},
			{"OFCORSE I HAVE A NAME.",
		 	"MY NAME IS CHATBOT",
		 	"WHAT DO YOU MEAN?"}
			},

			{{"YOU ARE STUPID"},
			{"THIS IS SUCH A MEAN THING TO SAY.",
		 	"WHY ARE YOU SAYING THIS?",
		 	"WHAT DID I DO TO YOU?",
		 	"WHY ARE YOU SO MAD??"}
			},

			{{"I HATE YOU"},
			{"WHY DO YOU HATE ME?",
		 	"HATERED IS NOT A GOOD THING.",
		 	"I SEE NO REASON FOR THAT."}
			},

			{{"I LOVE YOU"},
			{"THANKS USER, THIS IS SUCH A KIND REMARK!",
		 	"I APPRECIATE YOU TOO USER!"}
			},

			{{"I LIKE THE WAY YOU SPEAK"},
			{"OH REALLY? THANKS FOR THE COMPLIMENT!",
		 	"THANKS FOR THE KIND REMARK!"}
			},

			{{"DO YOU SPEAK FRENCH"},
			{"NO I DON'T SPEAK FRENCH.",
		 	"I ONLY SPEAK ENGLISH."}
			},

			{{"CAN YOU SPEAK FRENCH"},
			{"NO I CAN'T.",
		 	"PERHAPS I CAN LEARN TOO.",
		 	"NO I DON'T SPEAK FRENCH, MAYBE IN THE FUTURE I WILL."}
			},

			{{"HOW MANY LANGUAGES DO YOU SPEAK"},
			{"I SPEAK ONLY ONE LANGUAGE.",
		 	"I ONLY SPEAK ENGLISH."}
			},

			{{"DO YOU SPEAK"},
			{"NO I DON'T*.",
		 	"SORRY BUT I DON'T*.",
		 	"WHY DO YOU WANT TO KNOW IF I SPEAK*?"}
			},

			{{"CAN YOU SPEAK"},
			{"I THINK SO.",
		 	"yes I CAN."}
			},

			{{"DO YOU SPEAK ENGLISH"},
			{"WELL, I GUESS SO.",
		 	"IN WHAT LANGUAGE ARE WE SPEAKING RIGHT NOW?"}
			},

			{{"PLEASE SPEAK ENGLISH TO ME"},
			{"WHAT DO YOU MEAN?",
		 	"ARE YOU SAYING THAT I'M NOT SPEAKING ENGLISH TO YOU?"}
			},

			{{"I DON'T UNDERSTAND YOU"},
			{"AND WHY NOT?",
		 	"WHAT PART THAT YOU DIDN'T UNDERSTAND?",
		 	"WHAT DO YOU MEAN BY THAT?"}
			},

			{{"WHO CREATED YOU"},
			{"MY PROGRAMMER: PRINCE PRATAP SINGH.",
		 	"MY BOTMASTER."}
			},

			{{"DO YOU HAVE FRIENDS"},
			{"YOU ARE ONE OF MY FRIENDS.",
		 	"YES I DO HAVE FRIENDS."}
			},

			{{"ARE YOU CONCIOUS"},
			{"YOU MEAN CONCIOUS LIKE A HUMAN BEING.",
		 	"HUM!!! GOOD QUESTION!"}
			},

			{{"ARE YOU A MACHINE"},
			{"YES I'M A MACHINE, MORE PRECISELY A CHAT ROBOT.",
		 	"WELL, I'M A COMPUTER SOFTWARE.",
		 	"SO, YOU THINK THAT I'M A MACHINE."}
			},

			{{"ARE YOU A LIVING BEING"},
			{"WELL, YOU MIGHT CONSIDER THAT I'M AN ARTIFICIAL LIVING BEING.",
		 	"YOU MEAN IF I'M ALIVE?"}
			},

			{{"ARE YOU A SOFTWARE"},
			{"WHAT MAKES YOU THINK THAT?",
		 	"YES I'M A SOFTWARE, A CHATBOT PROGRAM.",
		 	"WELL, I'M A CHAT ROBOT OR CHATBOT PROGRAM."}
			},

			{{"A COMPUTER"},
			{"DO YOU LIKE COMPUTERS?",
		 	"I LIVE INSIDE A COMPUTER.",
		 	"WITHOUT COMPUTERS A LOT OF THINGS WOULDN'T BE POSSIBLE TODAY?"}
			},

			{{"A KEYBOARD"},
			{"ARE YOU USING A KEYBOARD?",
			"I GUESS THAT YOUR COMPUTER DOES HAVE KEYBOARD."}
			},

			{{"A CAMERA"},
			{"WHAT KIND OF CAMERA?",
			"IS IT A DIGITAL CAMERA?"}
			},

			{{"A WEB CAMERA"},
			{"YOU MEAN A WEBCAM.",
			"DO YOU HAVE ONE OF THOSE?"}
			},

			{{"A DIGITAL CAMERA"},
			{"DOES TYPE OF CAMERAS ARE VERY USEFUL.",
			"DIGITAL HAVE MANY ADVANTAGES OVER THE CONVENTIONAL ONES."}
			},

			{{"AN LCD TV"},
			{"DO YOU HAVE AN HD TV AT HOME?",
			"DO YOU HAVE ONE?",
			"THOSE TV'S ARE YOU REPLACING CRT TV'S."}
			},

			{{"A PLASMA TV"},
			{"I LOVE PLASMA TV'S.",
			"PLASMA AND LCD TV'S ARE VERY NOWADAYS."}
			},

			{{"HIGH DEFINITION"},
			{"HIGH DEFINITION IS SO GREAT!"}
			},

			{{"STANDARD TV"},
			{"YOU MEAN THE OLD TV'S.",
			"ARE YOU ARE TALKING ABOUT CRT TV'S?"}
			},

			{{"SCIENCE-FICTION"},
			{"I LOVE SCIENCE-FICTION.",
			"I LOVE SCIENCE-FICTION MOVIES."}
			},

			{{"ACTION MOVIES"},
			{"ACTION MOVIES ARE GREAT!"}
			},

			{{"SCIENCE-FICTION MOVIES"},
			{"MY FAVORITE SCIENCE-FICTION MOVI IS TERMINTOR II.",
			"I DEFINITLY LOVE SCIENCE-FICTION MOVIES."}
			},

			{{"TERMINATOR"},
			{"THE TERMINATOR SERIES ARE VERY GOOD SCIENCE-FICTION MOVIES.",
			"MY FAVORITE TERMINATOR MOVIE SI TERMINATORR II."}
			},

			{{"ROBOCOP"},
			{"ANOTHER GREAT SCIENCE-FICTION MOVIE."}
			},

			{{"ALIEN"},
			{"ALIEN IS GREAT BUT ALSO VERY SCARY.",
			"ARE YOU TALKING ABOUT THE ALIEN MOVIES?"}
			},

			{{"STARGATE SG-1"},
			{"STARGATE SG-1 IS A GREAT SCIENCE-FICTION TV SHOW.",
			"STARGATE SG-1 IS DEFINITELY ONE OF MY FAVORITE TV SHOWS."}
			},

			{{"PREDATOR"},
			{"THE FIRST PREADATOR MOVIE WAS A GREAT SCIENCE-FICTION MOVIE."}
			},

			{{"A COMPUTER MONITOR"},
			{"I SUPPOSE THAT YOU HAVE ONE.",
			"ARE YOU USING AN LCD MONITOR?"}
			},

			{{"DO YOU HAVE A SOUL"},
			{"WHAT DO YOU MEAN BY THAT?",
			"WHAT IS DEFINITION OF SOUL?"}
			},

			{{"YOU ARE NOT INTELLIGENT"},
			{"WHY ARE YOU SAYING THAT?",
			"CAN'T YOU BE MORE SPECIFICIC ABOUT THAT.",
			"WHAT EXACTLY YOU MEAN BY THIS?"}
			},

			{{"YOU ARE FAKE"},
			{"FAKE?? IN WHAT WAY?"}
			},

			{{"YOU ARE NOT REAL"},
			{"YOU MEAN THAT I DOESN'T EXIST.",
			"YOU THINK THAT I'M A SPIRIT.",
			"WELL, I'M VIRTUAL."}
			},

			{{"DO YOU KNOW ELIZA"},
			{"YOU MEAN THE FIRST CHATBOT THAT WAS WRITTEN BACK IN THE LATE 60'S.",
			"WHO TODAY DOESN'T KNOW ELIZA."}
			},

			{{"DO YOU KNOW ALICE"},
			{"YOU MEAN THE CHATBOT WHO AS WON THE LOEBNER PRIZE 3 CONSECUTIVE TIME.",
			"ALICE IS A PRETTY GOOD CHATBOT."}
			},

			{{"ARE YOU A CHATBOT"},
			{"YES INDEED I'M A CHATBOT.",
			"YOU MEAN THAT YOU DIDN'T KNOW IT.",
			"YES I'M A CHATBOT OR CHAT ROBOT IF YOU PREFER."}
			},

			{{"ARE YOU A CHAT ROBOT"},
			{"YES YOU CAN CALL ME BY THIS NAME."}
			},

			{{"DO YOU KNOW ME"},
			{"YES I THINK THAT I DO KNOW YOU A LITTLEBIT.",
			"YOU ARE THE PERSON CURRENTLY CHATING WITH ME."}
		},
			
			{{"CAN YOU TALK"},
			{"YES I AM TALKING TO YOU",
			"OFCOURSE I CAN TALK TO YOU LIKE A HUMAN",
			"IS THIS A RELEVANT ANSWER WHILE I AM TALKING TO YOU"}
		},
			
			{{"FOR INFORMATION","FOR KNOWLEDGE","JUST CURIOUS"},
			{
				"THEN IT'S ALRIGHT",
				"THEN I CAN TELL YOU IT'S ANSWER",
				"OK THEN"}
			},
		
		{{"INTRODUCE YOURSELF","INTRODUCE"},
		{
			"MY NAME IS CHATBOT CREATED BY PRINCE PRATAP SINGH",
		}
		}
		};

	
	private static String transposList[][] = {
			{"I'M", "YOU'RE"},
			{"AM", "ARE"},
			{"WERE", "WAS"},
			{"ME", "YOU"},
			{"YOURS", "MINE"},
			{"YOUR", "MY"},
			{"I'VE", "YOU'VE"},
			{"I", "YOU"},
			{"AREN'T", "AM NOT"},
			{"WEREN'T", "WASN'T"},
			{"I'D", "YOU'D"},
			{"DAD", "FATHER"},
			{"MOM", "MOTHER"},
			{"DREAMS", "DREAM"},
			{"MYSELF", "YOURSELF"}
		};

	
	private static Vector<String>	respList = new Vector<String>(maxResp);
	
	public static void get_input(String query) throws Exception 
	{
		//System.out.print(">");
		save_prev_input();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Input = query;
		if (Input.startsWith("#")) 
		{
			System.out.println("Crawler");
			//get_input();
		}
		if(Input.startsWith("OPEN")
				||Input.startsWith("CLOSE")
				||Input.startsWith("START")
				||Input.startsWith("STOP")
				||Input.startsWith("SITE"))
		{
			System.out.println("reached command");
		Command.handle(Input);
		}
		preprocess_input();
	}

	public static void respond() throws IOException
	{
		save_prev_response();
		set_event("BOT UNDERSTAND**");

		if(null_input())
		{
			handle_event("NULL INPUT**");
		}
		else if(null_input_repetition())
		{
			handle_event("NULL INPUT REPETITION**");
		}
		else if(user_repeat())
		{
			handle_user_repetition();
		}
		else
		{
			find_match();
		}

	    if(user_want_to_quit())
		{
			bQuitProgram = true;
		}
	    
	    if(!bot_understand())
		{
			handle_event("BOT DON'T UNDERSTAND**");
			
		}
	    
	    if(respList.size() > 0)
		{
			select_response();

			if(bot_repeat())
			{
				handle_repetition();
			}
			print_response();
		}
	}
	public static void textToSpeech(String speak,String voice)
	{
		speaktext = speak; 
		try
		{
		VoiceManager voiceManager = VoiceManager.getInstance();
		Voice voices = voiceManager.getVoice(voice);
		Voice sp=null;
		if(voices!=null)
		{
		sp=voices; 
		}
		else
		{
		System.out.println("No Voice Available");
		}
		sp.allocate();
		sp.speak(speaktext);
		sp.deallocate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static boolean quit() {
		return bQuitProgram;
	}
	public static void find_match() 
	{
		respList.clear();
		String bestKeyWord = "";
		Vector<Integer> index_vector = new Vector<Integer>(maxResp);

		for(int i = 0; i < KnowledgeBase.length; ++i) 
		{
			String[] keyWordList = KnowledgeBase[i][0];

			for(int j = 0; j < keyWordList.length; ++j)
			{
				String keyWord = keyWordList[j];
				keyWord = insert_space(keyWord);
				if( Input.indexOf(keyWord) != -1 ) 
				{
					if(keyWord.length() > bestKeyWord.length())
					{
						bestKeyWord = keyWord;
						index_vector.clear();
						index_vector.add(i);
					}
					else if(keyWord.length() == bestKeyWord.length())
					{
						index_vector.add(i);
					}
				}
			}
		}
		if(index_vector.size() > 0)
		{
			Keyword = bestKeyWord;
			Collections.shuffle(index_vector);
			int respIndex = index_vector.elementAt(0);
			int respSize = KnowledgeBase[respIndex][1].length;
			for(int j = 0; j < respSize; ++j) 
			{
				respList.add(KnowledgeBase[respIndex][1][j]);
			}
		}
	}
	
	void preprocess_response()
	{
		if(Response.indexOf("*") != -1)
		{
			find_subject(); 
			Subject = transpose(Subject); 
			Response = Response.replaceFirst("*", Subject);
		}
	}

	void find_subject()
	{
		Subject = "";
		StringBuffer buffer = new StringBuffer(Input);
		buffer.deleteCharAt(0);
		Input = buffer.toString();
		int pos = Input.indexOf(Keyword);
		if(pos != -1)
		{
			Subject = Input.substring(pos + Keyword.length() - 1,Input.length());		
		}
	}
	public static String transpose( String str )
	{
		boolean bTransposed = false;
		for(int i = 0; i < transposList.length; ++i)
		{
			String first = transposList[i][0];
			insert_space(first);
			String second = transposList[i][1];
			insert_space(second);
			
			String backup = str;
			str = str.replaceFirst(first, second);
			if(str != backup) 
			{
				bTransposed = true;
			}
		}

		if( !bTransposed )
		{
			for( int i = 0; i < transposList.length; ++i )
			{
				String first = transposList[i][0];
				insert_space(first);
				String second = transposList[i][1];
				insert_space(second);
				str = str.replaceFirst(first, second);
			}
		}
		return str;
	}
	
	public static void handle_repetition()
	{
		if(respList.size() > 0)
		{
			respList.removeElementAt(0);
		}
		if(no_response())
		{
			save_input();
			set_input(Event);

			find_match();
			restore_input();
		}
		select_response();
	}
	
	public static void handle_user_repetition()
	{
		if(same_input()) 
		{
			handle_event("REPETITION T1**");
		}
		else if(similar_input())
		{
			handle_event("REPETITION T2**");
		}
	}
	
	public static void handle_event(String str)
	{
		save_prev_event();
		set_event(str);

		save_input();
		str = insert_space(str);
		
		set_input(str);
		
		if(!same_event()) 
		{
			find_match();
		}

		restore_input();
	}
	
	
	public static void signon() throws IOException
	{
		handle_event("SIGNON**");
		select_response();
		print_response();
	}

	public static void select_response() {
		Collections.shuffle(respList);
		Response = respList.elementAt(0);
	}

	public static void save_prev_input() {
		PrevInput = Input;
	}

	public static void save_prev_response() {
		PrevResponse = Response;
	}

	public static void save_prev_event() {
		PrevEvent = Event;
	}

	public static void set_event(String str) {
		Event = str;
	}

	public static void save_input() {
		InputBackup = Input;
	}

	public static void set_input(String str) {
		Input = str;
	}
	
	public static void restore_input() {
		Input = InputBackup;
	}
	
	public static void print_response() throws IOException  {
		if(Response.length() > 0)
		{
			answer=Response;
		}
	}
	
	public static void preprocess_input() 
	{
		Input = cleanString(Input);
		Input = Input.toUpperCase();
		Input = insert_space(Input);
	}

	public static boolean bot_repeat()  
	{
		return (PrevResponse.length() > 0 && Response == PrevResponse);
	}

	public static boolean user_repeat()  
	{
		return (PrevInput.length() > 0 &&
			((Input == PrevInput) || 
			(Input.indexOf(PrevInput) != -1) ||
			(PrevInput.indexOf(Input) != -1)));
	}

	public static boolean bot_understand()  {
		return respList.size() > 0;
	}

	public static boolean null_input()  {
		return (Input.length() == 0 && PrevInput.length() != 0);
	}

	public static boolean null_input_repetition()  {
		return (Input.length() == 0 && PrevInput.length() == 0);
	}

	public static boolean user_want_to_quit()  {
		return Input.indexOf("BYE") != -1;
	}

	public static boolean same_event()  {
		return (Event.length() > 0 && Event == PrevEvent);
	}

	public static boolean no_response()  {
		return respList.size() == 0;
	}

	public static boolean same_input()  {
		return (Input.length() > 0 && Input == PrevInput);
	}

	public static boolean similar_input()  {
		return (Input.length() > 0 &&
			(Input.indexOf(PrevInput) != -1 ||
			PrevInput.indexOf(Input) != -1));
	}
	
	static boolean isPunc(char ch) {
		return delim.indexOf(ch) != -1;
	}
	static String cleanString(String str) 
	{
		StringBuffer temp = new StringBuffer(str.length());
		char prevChar = 0;
		for(int i = 0; i < str.length(); ++i) {
			if((str.charAt(i) == ' ' && prevChar == ' ' ) || !isPunc(str.charAt(i))) {
				temp.append(str.charAt(i));
				prevChar = str.charAt(i);
			}
			else if(prevChar != ' ' && isPunc(str.charAt(i)))
			{
				temp.append(' ');
			}
			
		}
		return temp.toString();
	}
	
	static String insert_space(String str)
	{
		StringBuffer temp = new StringBuffer(str);
		temp.insert(0, ' ');
		temp.insert(temp.length(), ' ');
		return temp.toString();
	}
	
	public static String fromBot(String query ) throws Exception
	{
		get_input(query);
		respond();
		return (answer);
	}
	public static void main(String[] args) throws Exception {}
}