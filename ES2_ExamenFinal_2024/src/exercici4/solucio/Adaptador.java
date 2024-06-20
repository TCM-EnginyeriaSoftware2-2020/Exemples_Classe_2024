package exercici4.solucio;

import exercici4.AbstractTren;
import exercici4.ITren;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Adaptador implements ITren {
    private AbstractTren adaptable;

    public Adaptador(AbstractTren adaptable)
    { this.adaptable = adaptable; }

    @Override
    public boolean comprovaAmplada(int ampladaVia) {
        if( this.adaptable.getAmplada() != ampladaVia) {
            try {
                Field lAtribut = AbstractTren.class.getDeclaredField("amplada");
                lAtribut.setAccessible(true);
                lAtribut.set(adaptable, ampladaVia);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return this.adaptable.getAmplada() == ampladaVia;
    }

    @Override
    public int getSeients() {
        try {
            Field lAtribut = AbstractTren.class.getDeclaredField("seients");
            lAtribut.setAccessible(true);
            return (int) lAtribut.get(adaptable);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getVelocitatMaxima() {
        try {
            Method elMetode = AbstractTren.class.getDeclaredMethod("getVelocitatMaxima");
            elMetode.setAccessible(true);
            return (int) elMetode.invoke(adaptable);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
