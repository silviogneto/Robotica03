package exec;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import model.AndarFrente;
import model.Arvore;
import model.Mapear;
import model.NoArvore;

public class Main {

	public static boolean mapeando = true;
	public static boolean chegouObjetivo = false;
	public static boolean rodasMenorCaminho = false;
	public static Arvore arvore = new Arvore(new NoArvore(null, 'r'));
	
	public static void main(String[] args) {
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);
		ColorSensor color = new ColorSensor(SensorPort.S2);
		
		while (!Button.ENTER.isPressed());
		
		Behavior andar = new AndarFrente();
		Behavior mapear = new Mapear(sonic, color);
		Behavior[] comportamentos = { andar, mapear };
		
		//arvore.adicionarNo('f');
		
		Arbitrator arbitrator = new Arbitrator(comportamentos);
		arbitrator.start();
	}
}
