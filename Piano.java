//the code is a bit of a mess but its a nice piano if u wanna just play and enjoy
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.AudioPermission;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Piano extends JPanel implements KeyListener{

	/**
	 * @param args
	 */
	boolean a[];
	char s;
	public boolean pri=false;
	MidiChannel[] chan;
	JLabel tf;
	public Piano(int n)
	{
		super(new BorderLayout());
		List<Integer> i=new ArrayList<Integer>(n);
		addKeyListener(this);
		setFocusable(true);
		tf=new JLabel("hello",this.getWidth()/2);
		tf.setBackground(Color.cyan);
		tf.setSize(80,80);
		
		 // Obtains the default Sequencer connected to a default device.
		//play a midi file!!
		        Sequencer sequencer;
				try {
					sequencer = MidiSystem.getSequencer();
					sequencer.open();
					
			        InputStream is = new BufferedInputStream(new FileInputStream(new File("/Users/neon/Downloads/beethoven.mid")));
			
			        sequencer.setSequence(is);
			        
			 
			
			        // Starts playback of the MIDI data in the currently loaded sequence.
			
			        //sequencer.start();
				} catch (MidiUnavailableException | IOException | InvalidMidiDataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		        

		//tf.setFocusable(true);
		tf.setVisible(true);
		this.add(tf);
		this.validate();
		//Main b=new Main(0);
		
		//i.add(0);
		
		try {
			Synthesizer s=MidiSystem.getSynthesizer();
			s.open();
			chan=s.getChannels();
			System.out.println(chan.length);
			int k=0;
			
			//s.close();
			
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String a="HIIII M DISHA";
		/*int first=1,second=2;
		boolean l,k=true;
		l=true;
		int play1,start=2,count=0;
		for(;;)
		{
			play1=first+second-1;
			first=second;second=play1;
			play1=play1%7;
			int notes[]=new int[7];
			//60-12 will be a lower octave of c...60=c note, 61=c# and goes on....
			notes[0]=60;//c
			notes[1]=62;//d
			notes[2]=64;//e
			notes[3]=65;//f
			notes[4]=67;//g
			notes[5]=69;//a
			notes[6]=71-12;//b
			
			if(play1<0 || play1>6)
				{play1=start; first=start+1;second=first+2;start=start+1;System.out.println("changed");}
			if(start>6)
			{
				start=0;
			}
			System.out.print(notes[6-play1]+"  ");
			if(l)//alternatively playing higher octave and the lower octave
			{
				play((char)(notes[play1]-3));
				//play((char)(notes[play1]));

				//lower octave!! change notes[play1]-4 means 4 half notes below the not that should be played..
				l=false;
			}
			
			else
			{
				
				play((char)(notes[play1]+9));
				//play((char)(notes[play1]));

				//higher octave!!
				l=true;
			}
				
			try {
				if(k)
				{
					if(count>7)//this is where it takes an empty note, or a break, increase this so it will take a break later on...
					{
						count=0;
						//k=false;
					}
					count++;
					Thread.sleep(300);//rate at which it is playing...decrement it if need to go faster
				}
				else
				{
					k=true;
					Thread.sleep(600);//this is the break period, keep it double the rate...e.g 400=2*200!!
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void play(char s)
	{
		if(chan[0]!=null)
		{
			chan[0].noteOn(s-5, 100);
			tf.setText("" + s+" "+(int)s);
			try {
				//Thread.sleep(100);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//chan[0].noteOff(60);
			System.out.println("played");
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("this is the value"+(s=e.getKeyChar()));
		play(s);
		pri=true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
class M{
	public static void main(String srgs[])
	{
		JFrame jf=new JFrame("the Piano");
		
		Main v=new Piano(6);
		jf.setSize(800,500);
		jf.add(v);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while(true)
		{
			if(v.pri)
			{
				System.out.println(v.s);
				v.pri=false;
			}
			
		}
		//System.out.println();
	}
}
