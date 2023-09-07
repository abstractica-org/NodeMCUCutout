package org.abstractica.javacsgmodules.nodemcucutout;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class NodeMCUv2Cutout
{
	private double xSize = 26.2;
	private double ySize = 48.6;
	private double zSize = 6.0;
	private double holeSize = 2.6;
	private double holeXDist = 21.0;
	private double holeYDist = 43.4;
	private double pinLength = 38.4;
	private double pinWidth = 3.0;
	private double pinHeight = 10.0;
	private double pinXDist = 22.6;
	private double usbWidth = 12.0;
	private double usbLength = 20.0;
	private double usbHeight = 6.0;

	public Geometry3D getCutout(JavaCSG csg)
	{
		//Base
		Geometry3D base = csg.box3D(xSize, ySize, zSize, false);
		Geometry3D hole = csg.cylinder3D(holeSize, zSize+2, 32, false);

		//Holes
		hole = csg.translate3DZ(-1).transform(hole);
		Geometry3D hole1 = csg.translate3D(0.5*holeXDist, 0.5*holeYDist, 0).transform(hole);
		Geometry3D hole2 = csg.translate3D(-0.5*holeXDist, 0.5*holeYDist, 0).transform(hole);
		Geometry3D hole3 = csg.translate3D(0.5*holeXDist, -0.5*holeYDist, 0).transform(hole);
		Geometry3D hole4 = csg.translate3D(-0.5*holeXDist, -0.5*holeYDist, 0).transform(hole);
		base = csg.difference3D(base, hole1, hole2, hole3, hole4);

		//Pins
		Geometry3D pin = csg.box3D(pinWidth, pinLength, pinHeight+1, false);
		pin = csg.translate3DZ(-pinHeight).transform(pin);
		Geometry3D pin1 = csg.translate3DX(-0.5*pinXDist).transform(pin);
		Geometry3D pin2 = csg.translate3DX(0.5*pinXDist).transform(pin);
		base = csg.union3D(base, pin1, pin2);

		//USB
		Geometry3D usb = csg.box3D(usbWidth, usbLength+1, usbHeight, false);
		usb = csg.translate3DZ(0.5*(zSize- usbHeight)).transform(usb);
		usb = csg.translate3DY(0.5*ySize - 0.5*(usbLength + 1) + usbLength).transform(usb);
		base = csg.union3D(base, usb);
		return base;
	}
}
