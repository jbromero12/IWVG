package ticTacToe.v430.views.console;

import ticTacToe.v430.controllers.CoordinateController;
import ticTacToe.v430.controllers.RandomCoordinateController;
import ticTacToe.v430.controllers.UserCoordinateController;
import ticTacToe.v430.models.Coordinate;

class MoveTargetCoordinateView extends ColocateCoordinateView {

	private Coordinate origin;
	
	private Coordinate target;

	MoveTargetCoordinateView(CoordinateController coordinateController, Coordinate origin) {
		super(coordinateController);
		assert origin != null;
		this.origin = origin;
	}
	
	Coordinate getCoordinate() {
		this.getCoordinateController().accept(this);
		return target;
	}
	
	@Override
	public void visit(UserCoordinateController userCoordinateController) {
		target = userCoordinateController.getTarget();
		CoordinateView.instance().read("A", target);
	}

	@Override
	public void visit(RandomCoordinateController randomCoordinateController) {
		target = randomCoordinateController.getTarget(origin);
		this.show("pone en", target);
	}
	
}
