package tplab;

import java.awt.Graphics;

public interface ITransport {
	void SetPosition(int x, int y, int width, int height);
    void MoveTransport(Direction direction);
    void DrawAircraft(Graphics g);
}
