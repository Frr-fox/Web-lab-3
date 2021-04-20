import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ManagedBean(name = "point")
@Data
@NoArgsConstructor
public class PointBean implements Serializable {
    private double xValue = 0;
    private double yValue;
    private double rValue = 3.5;
    private String yText = "";
    private double xHiddenValue;
    private double yHiddenValue;
    private double rHiddenValue;
    private boolean inArea;
    private String time;

    public PointBean(double xValue, double yValue, double rValue) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.rValue = rValue;
    }

    public void check() {
        this.setTime(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
        this.setInArea(checkFunction());
    }

    public boolean checkFunction() {
        return (xValue <= 0 && yValue >= 0 && (xValue*xValue + yValue*yValue <= rValue*rValue/4)) ||
                (xValue >= 0 && yValue >= 0 && xValue <= rValue && yValue <= rValue/2) || (xValue <= 0 && yValue <= 0 &&
                (yValue >= -2*xValue - rValue));
    }

    public void initForm() {
        this.xValue = 0;
        this.yText = "";
        this.rValue = 3.5;
    }

    public String getYText() {
        return Double.toString(yValue);
    }

    public void setYText(String yText) {
        yText = yText.trim().replace(",", ".");
        this.yText = yText;
        this.yValue = Double.parseDouble(this.yText);
    }
}
