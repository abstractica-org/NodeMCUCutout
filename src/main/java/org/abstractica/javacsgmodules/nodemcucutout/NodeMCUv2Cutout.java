package org.abstractica.javacsgmodules.nodemcucutout;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class NodeMCUv2Cutout
{
	public Geometry3D getCutout(JavaCSG csg)
	{
		Geometry3D box = csg.box3D(20, 10, 10, false);
		return box;
	}
}
