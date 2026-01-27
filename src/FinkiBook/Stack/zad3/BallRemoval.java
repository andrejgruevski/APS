package FinkiBook.Stack.zad3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;
//Да се напише алгоритам со коj ´ке се имплементира играта “Поништување топчиња”. Во оваа игра на располагање имате топчиња во три различни бои (R-црвена,
//                                                                                                                                               G-зелена и B-сина), обележани со знакот + или -. Поништување на топчиња може да настане само доколку тие се од иста боjа и со спротивен знак. На почеток
//се генерира една случаjна листа со топчиња. Ваша задача е од тоj влез, како
//доа´гаат топчињата да направите поништување и да кажете колку, од каков тип
//(+ или -) и од коjа боjа фалат за да се поништат сите топчиња од влезот.
//Влез: Во влезот е дадена листа од случаjни топчиња и тоа во облик: боjа,
//знак.
//Излез: На излез треба да се испечатат броjот на парови и паровите кои може
//да се формираат.
//Пример:
//Влез: R+ G- G+ G+ R+ B- B+ R- G+ R- B- B+ B+ R+
//Парови кои може да се формираат од овоj список се: (R+,R-); (B+, B-); (BB+); (R+, R-); (G-, G+); (R+, R-)
// Остануваат без партнер: G+, G+, B+, R+
//Излез:
//4
//R- G- G- B+
public class BallRemoval {
    public static String ballRemoval(List l) {
        Stack<String> red = new Stack<>();
        Stack<String> green = new Stack<>();
        Stack<String> blue = new Stack<>();

        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i).toString();
            if (s.charAt(0) == 'R') {
                if (!red.isEmpty()) {
                    if (red.peek().equals(s)) {
                        red.push(s);
                    } else {
                        red.pop();
                    }
                } else {
                    red.push(s);
                }
            }

            if (s.charAt(0) == 'G') {
                if (!green.isEmpty()) {
                    if (green.peek().equals(s)) {
                        green.push(s);
                    } else {
                        green.pop();
                    }
                } else {
                    green.push(s);
                }
            }

            if (s.charAt(0) == 'B') {
                if (!blue.isEmpty()) {
                    if (blue.peek().equals(s)) {
                        blue.push(s);
                    } else {
                        blue.pop();
                    }
                } else {
                    blue.push(s);
                }
            }
        }
        int counter = 0;
        String answer = new String();
        while (!red.isEmpty()) {
            counter++;
            if (red.pop().charAt(1) == '+') {
                answer += "R- ";
            } else {
                answer += "R+ ";
            }
        }

        while (!green.isEmpty()) {
            counter++;
            if (green.pop().charAt(1) == '+') {
                answer += "G- ";
            } else {
                answer += "G+ ";
            }
        }

        while (!blue.isEmpty()) {
            counter++;
            if (blue.pop().charAt(1) == '+') {
                answer += "B- ";
            } else {
                answer += "B+ ";
            }
        }

        System.out.println(counter);
        return answer;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        String line[] = new String[100];
        line = sc.nextLine().split(" ");
        List<String> balls = new LinkedList<String>();
        for (int i = 0; i < line.length; i++) {
            balls.add(line[i]);
        }

        System.out.println(ballRemoval(balls));
    }
}
