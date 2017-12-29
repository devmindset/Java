
public class GeoUtils {
	
    public static float EARTH_RADIUS_KM = 6371F;
	/*
	 * Calculate distance between two points. Defaults to Miles as the unit of distance
	 */
	public static float distance(double lt1, double lg1, double lt2, double lg2) {
		
		return distance(lt1, lg1, lt2, lg2, 'M');
	}

    public static float euclideanDistance(double x1, double y1, double x2, double y2) {
             return (float) Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

    }


    /**
	 * Calculate distance between two points.
	 * @param unit 'K' = Kilometers 'N' = Nautical Miles 'M' = Miles
	 */
	public static float distance(double lt1, double lg1, double lt2, double lg2, char unit) {
		
		double theta = lg1 - lg2;
		double d = 
				Math.sin(rad(lt1)) * Math.sin(rad(lt2)) + 
				Math.cos(rad(lt1)) * Math.cos(rad(lt2)) * 
				Math.cos(rad(theta));
		
		d = deg(Math.acos(d)) * 60 * 1.1515;
		
		if (unit == 'K') d *= 1.609344;
		if (unit == 'N') d *= 0.8684;
		
		return (float) d;
	}
	
	public static double deg(double radians) {
		return radians * 180 / Math.PI;
	}
	
	public static double rad(double degrees) {
		return degrees * Math.PI / 180.0;
	}

    public static Float[] getBoundingBox(Float centreLat, Float centreLon, Float radius, boolean inKms) {
        if(inKms == false)
            radius *= 1.609344F;
        Float[] bb = new Float[4];
        bb[0] = centreLat + (float)Math.toDegrees(radius/EARTH_RADIUS_KM);
        bb[1] = centreLon - (float)Math.toDegrees(radius/EARTH_RADIUS_KM/Math.cos(Math.toRadians(centreLat)));
        bb[2] = centreLat - (float)Math.toDegrees(radius/EARTH_RADIUS_KM);
        bb[3] = centreLon + (float)Math.toDegrees(radius/EARTH_RADIUS_KM/Math.cos(Math.toRadians(centreLat)));
        return bb;
    }
}

