package test.task.tasks;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * @author Mukan Atazhanov
 * @project tasks
 * @created 15/02/2022 - 23:12
 */

@RestController
@RequestMapping("/tasks")
public class Controller {


    //can use pathvariable too
    /*@GetMapping("/solve1/{text}")
    public String solve(@PathVariable String text)*/

    @GetMapping("/solve1")
    public String solve(@RequestParam(value = "text", defaultValue = "Mukan Atazhanov") String text) {
        StringBuilder reversed = new StringBuilder();
        String t2 = text.replaceAll("\\s+", " ");
        int len = t2.length();

        //reversed cycle
        for(int i = len - 1; i >= 0; i--){
            reversed.append(t2.charAt(i));
        }

        //a,e,i,o,u
        //change chars to uppercase in new string where vowels were located in origin text
        for(int j = 0; j < len; j++){
            if(t2.charAt(j) == 'a' || t2.charAt(j) == 'A' ||
                    t2.charAt(j) == 'á' || t2.charAt(j) == 'Á' ||
                    t2.charAt(j) == 'e' || t2.charAt(j) == 'E' ||
                    t2.charAt(j) == 'é' || t2.charAt(j) == 'É' ||
                    t2.charAt(j) == 'ě' || t2.charAt(j) == 'Ě' ||
                    t2.charAt(j) == 'i' || t2.charAt(j) == 'I' ||
                    t2.charAt(j) == 'í' || t2.charAt(j) == 'Í' ||
                    t2.charAt(j) == 'u' || t2.charAt(j) == 'U' ||
                    t2.charAt(j) == 'ů' || t2.charAt(j) == 'Ú' ||
                    t2.charAt(j) == 'ú' || t2.charAt(j) == 'Ů' ||
                    t2.charAt(j) == 'o' || t2.charAt(j) == 'O') {
                char c = Character.toUpperCase(reversed.charAt(j));
                reversed.setCharAt(j, c);
            }
        }
        return reversed.toString();
    }

    /*Výpočet provede postupně takto:

      - všechny číslice menší 3 (včetně) posune o jednu pozici doprava. Např: 43256791 => 45326791

      - všechny číslice 8 a 9 vynásobí 2. Např.: 45326791 => 453267181

      - všechny číslice 7 smaže: Např: 453267181 => 45326181

      - ve výsledném čísle spočte počet sudých číslic a tímto počtem výsledné číslo vydělí a
      zaokrouhlí dolů na celá čísla. Např: 45326181 / 4 => 11331545

    Pro zadané číslo 43256791 je výsledek 11331545.*/

    //todo switching pos and finding amount of even number
    @GetMapping("/solve2")
    public String num(@RequestParam(value = "number", defaultValue = "43256791") Integer number) {
        String temp = Integer.toString(number);
        int[] intArr = new int[temp.length()];
        int evenNum = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < temp.length(); i++) {
            intArr[i] = temp.charAt(i) - '0';
        }
        for(int j : intArr) {
            switch (j) {
                case 8:
                case 9:
                    res.append(j * 2);
                    break;
                case 7:
                    continue;
                default:
                    res.append(j);
            }
        }

        return res.toString();
    }
}
