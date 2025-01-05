// BEGIN
package exercise.dto;

import lombok.Getter;

@Getter
public abstract class BasePage {
    private String flash;
    private FlashType flashType;

    public enum FlashType {
        success,
        danger,
    }

    public void setFlash(String flashText, FlashType status) {
        flash = flashText;
        flashType = status;
    }
}
// END
