import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.nodemcucutout.NodeMCUv2Cutout;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();

		NodeMCUv2Cutout cutout = new NodeMCUv2Cutout();

		Geometry3D cutoutGeometry = cutout.getCutout(csg);
		cutoutGeometry = csg.translate3DZ(3).transform(cutoutGeometry);

		Geometry3D box = csg.box3D(30, 60, 7, false);

		Geometry3D result = csg.difference3D(box, cutoutGeometry);

		csg.view(result);

	}
}
