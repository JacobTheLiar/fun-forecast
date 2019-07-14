
package pl.jacob_the_liar.forecast.seven_timer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind10m {

    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("speed")
    @Expose
    private Integer speed;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

}
