package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LEDCommand {
    public static AddressableLEDBuffer setStripColor(int length, int r, int g, int b) {
        AddressableLEDBuffer m_ledbuffer = new AddressableLEDBuffer(length);
        for (int i = 0; i < m_ledbuffer.getLength(); i++) {
            m_ledbuffer.setRGB(i, r, g, b);
        }
        return m_ledbuffer;
    }
}
