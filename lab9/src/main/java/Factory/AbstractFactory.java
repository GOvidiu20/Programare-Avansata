package Factory;

import EntiyPack.Movie;

public abstract class AbstractFactory {
    public abstract Connection getConnection(String connection);
}
