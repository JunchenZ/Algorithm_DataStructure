package assignment00;

public class Vector3D implements Mathable<Vector3D> {

  double xComponent, yComponent, zComponent;

  public Vector3D(double x, double y, double z) {
    xComponent = x;
    yComponent = y;
    zComponent = z;
  }

  // calculate and return the magnitude
  public double getMagnitude() {
    return Math.sqrt(Math.pow(xComponent, 2) + Math.pow(yComponent, 2) + Math.pow(zComponent, 2));
  }

  // two vectors are equal if each component is equal
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Vector3D) {
      Vector3D vector3D = (Vector3D) obj;
      return (Math.abs(this.xComponent - vector3D.xComponent) < Math.pow(10, -6)
          && Math.abs(this.yComponent - vector3D.yComponent) < Math.pow(10, -6)
          && Math.abs(this.zComponent - vector3D.zComponent) < Math.pow(10, -6));
    } else
      return false;
  }

  // return the string in "(x, y, z)" format
  @Override
  public String toString() {
    return "(" + xComponent + ", " + yComponent + ", " + zComponent + ")";
  }

  // add two vectors by adding the corresponding components
  @Override
  public Vector3D plus(Vector3D rhs) {
    return new Vector3D(this.xComponent + rhs.xComponent, this.yComponent + rhs.yComponent,
        this.zComponent + rhs.zComponent);
  }

  // calculate the cross product of two vectors
  @Override
  public Vector3D times(Vector3D rhs) {
    return new Vector3D(this.yComponent * rhs.zComponent - this.zComponent * rhs.yComponent,
        this.zComponent * rhs.xComponent - this.xComponent * rhs.zComponent,
        this.xComponent * rhs.yComponent - this.yComponent * rhs.xComponent);
  }

}
