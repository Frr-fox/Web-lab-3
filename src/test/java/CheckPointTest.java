import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CheckPointTest {

    private String getMsg(double x,  double y, double r) {
        return "Failure in point (" + x + ", " + y + ") with r = " + r;
    }

    //center
    @Test
    public void testPointOfCenter() {
        PointBean point = new PointBean(0, 0, 1);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    //rectangle
    @Test
    public void testPointRightBottomOfRect() { //  правый низ прямоугольника
        PointBean point = new PointBean(3, 0, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointInRightBottomOfRect() { //  правый низ прямоугольника
        PointBean point = new PointBean(2.9, 0.13, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointOutRightBottomBelowOfRect() { //  правый низ прямоугольника
        PointBean point = new PointBean(2.9, -0.13, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointOutRightBottomDexterOfRect() { //  правый низ прямоугольника
        PointBean point = new PointBean(3.1, 0.13, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointRightTopOfRect() { //  правый верх прямоугольника
        PointBean point = new PointBean(3, 1.5, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointInRightTopOfRect() { //  правый верх прямоугольника
        PointBean point = new PointBean(2.9, 1.4, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointOutRightTopDexterOfRect() { //  правый верх прямоугольника
        PointBean point = new PointBean(3.1, 1.4, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointOutRightTopAboveOfRect() { //  правый верх прямоугольника
        PointBean point = new PointBean(2.8,  1.6, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointInLeftTopOfRect() { //  левый верх прямоугольника
        PointBean point = new PointBean(0.3,  1.35, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointOutLeftTopAboveOfRect() { //  левый верх прямоугольника
        PointBean point = new PointBean(0.2,  1.68, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointLeftBottomOfRect() { //  пересечение левого верх прямоугольника с окружн
        PointBean point = new PointBean(0,  1.5, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    //circle
    @Test
    public void testPointOutTopOfCircle() { //  левый верх снаружи круга
        PointBean point = new PointBean(-0.6,  1.52, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointInTopOfCircle() { //  левый верх внтури круга
        PointBean point = new PointBean(-0.4,  1.27, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointInBottomOfCircle() { //  левый низ внутри круга
        PointBean point = new PointBean(-1.3,  0.35, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointOutBottomOfCircle() { //  левый низ снаружи круга
        PointBean point = new PointBean(-1.6,  0.38, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointLeftOfCircle() { //  пересечение левого верх прямоугольника с окружн
        PointBean point = new PointBean(-1.5,  0, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    //triangle
    @Test
    public void testPointOutLeftTopOfTriangle() { //  верхняя слева снаружи треугольника
        PointBean point = new PointBean(-1.3,  -0.65, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointInLeftTopOfTriangle() { //   верхняя слева внутри треугольника
        PointBean point = new PointBean(-1.0,  -0.65, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointInLeftBottomOfTriangle() { //  нижняя слева внутри треугольника
        PointBean point = new PointBean(-0.2,  -2.2, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointOutLefBottomOfTriangle() { //  нижняя слева снаружи треугольника
        PointBean point = new PointBean(-0.5,  -2.2, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointBottomOfTriangle() { //  нижняя вершина треугольника
        PointBean point = new PointBean(0.0,  -3.0, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointRightSideOutOfTriangle() { //  снаружи правой стороны треугольника
        PointBean point = new PointBean(0.2,  -1.25, 3);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void testPointRightSideInOfTriangle() { //  внутри правой стороны треугольника
        PointBean point = new PointBean(-0.1,  -1.25, 3);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    // another r

    @Test
    public void test1() {
        PointBean point = new PointBean(-1.0,  0.9, 2);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void test2() {
        PointBean point = new PointBean(-0.4,  0.3, 2);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void test3() {
        PointBean point = new PointBean(-1.1,  -1.15, 2);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void test4() {
        PointBean point = new PointBean(1.3,  1.35, 2);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void test5() {
        PointBean point = new PointBean(0.7,  -0.63, 2);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void test6() {
        PointBean point = new PointBean(1.1,  0.5, 2);
        boolean result = point.checkFunction();
        assertTrue(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void test7() {
        PointBean point = new PointBean(2.4,  0.4, 2);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }

    @Test
    public void test8() {
        PointBean point = new PointBean(2.1,  2, 2);
        boolean result = point.checkFunction();
        assertFalse(getMsg(point.getXValue(), point.getYValue(), point.getRValue()), result);
    }
}
