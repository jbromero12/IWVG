package ticTacToe.v470.controllers.local;

import ticTacToe.v470.controllers.ContinueController;
import ticTacToe.v470.controllers.OperationControllerVisitor;
import ticTacToe.v470.models.Game;
import ticTacToe.v470.models.Observer;
import ticTacToe.v470.models.Subject;

public class LocalContinueController extends LocalOperationController implements
		ContinueController {

	private Subject subject;
	
	public LocalContinueController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}

	public void resume(boolean another) {
		if (another) {
			this.clear();
			subject.initialize();
		} else {
			subject.exit();
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
