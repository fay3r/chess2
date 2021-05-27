package pl.edu.pwsztar.chess.domain;

interface RulesOfGame {

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia
     * source na destination w jednym ruchu jest zgodne
     * z zasadami gry w szachy
     */
    boolean isCorrectMove(Point source, Point destination);

    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if (source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            }

            return Math.abs(destination.getX() - source.getX()) ==
                    Math.abs(destination.getY() - source.getY());
        }
    }

    class Knight implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            int newX = destination.getX(), newY = destination.getY();
            int srcX = source.getX(), srcY = source.getY();
            System.out.println(Math.abs(newX - srcX) * Math.abs(newY - srcY));
            if (srcX == newX && srcY == newY) {
                return false;
            } else if (Math.abs(newX - srcX) * Math.abs(newY - srcY) == 2) {
                return true;
            } else {
                return false;
            }
        }
    }

    // TODO: Prosze dokonczyc implementacje kolejnych figur szachowych: Knight, King, Queen, Rook, Pawn
    // TODO: Prosze stosowac zaproponowane nazwy klas !!!
    // TODO: Kazda klasa powinna implementowac interfejs RulesOfGame

    class Rook implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if (source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            } else if (source.getX() == destination.getX() || source.getY() == destination.getY()) {
                return true;
            } else {
                return false;
            }
        }
    }

    class King implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if (source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            } else if ((Math.abs(source.getX() - destination.getX()) == 1 ||
                    Math.abs(source.getX() - destination.getX()) == 0 ||
                    Math.abs(source.getX() - destination.getX()) == -1)
                    && (Math.abs(source.getY() - destination.getY()) == 1 ||
                    Math.abs(source.getY() - destination.getY()) == 0 ||
                    Math.abs(source.getY() - destination.getY()) == -1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    class Queen implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if (source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            } else if (source.getX() == destination.getX() || source.getY() == destination.getY()) {
                return true;
            } else if (Math.abs(destination.getX() - source.getX()) ==
                    Math.abs(destination.getY() - source.getY())) {
                return true;
            } else {
                return false;
            }
        }
    }

    class Pawn implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if (source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            } else if (source.getX() - destination.getX() == -1 && source.getY() == destination.getY()) {
                return true;
            } else {
                return false;
            }
        }
    }

}
