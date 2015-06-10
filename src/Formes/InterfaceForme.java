package Formes;

import java.awt.Graphics;

public interface InterfaceForme {

	public void dessinerForme(Graphics g);
	public double calculeAire();
	public void setPosition(int x, int y);
	public int getNumSeq();
	public Encadrer getEncadree();
}
