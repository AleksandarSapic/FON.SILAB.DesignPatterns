package Subject;

import Observer.Observer;

public class Subject {

    Observer cs[];

    public Subject() {
        cs = new Observer[3];
    }

    public void setObserver(int index, Observer cs1) {
        cs[index] = cs1;
    }

    public void Notify(int brojPrijave) {
        for (Observer c : cs) {
            c.Update(brojPrijave);
        }
    }
}
