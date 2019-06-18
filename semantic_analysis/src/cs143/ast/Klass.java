package cs143.ast;

import cs143.ast.Ast;

import java.io.PrintStream;
import java.util.List;

public class Klass extends Ast {

    String class_name;
    String base_class_name;
    String file_name;

    List<Feature> features;

    public Klass(int line_num) {
        super(line_num);
    }

    public Klass(int line_num, String class_name, String base_class_name, String file_name, List<Feature> features) {
        this(line_num);
        this.class_name = class_name;
        this.base_class_name = base_class_name;
        this.file_name = file_name;
        this.features = features;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_class");
        ps.println(padding(pad+2) + class_name);
        ps.println(padding(pad+2) + base_class_name);
        ps.println(padding(pad+2) + file_name);
        ps.println(padding(pad+2) + "(");
        for (Feature f : features) {
            f.dump(ps, pad+2);
        }
        ps.println(padding(pad+2) + ")");
    }

    public String class_name() { return class_name; }
    public String base_class_name() { return base_class_name; }
    public String file_name() { return file_name; }
    public List<Feature> features() { return features; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitKlass(this);
    }
}
