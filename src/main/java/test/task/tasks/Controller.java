package test.task.tasks;

import org.springframework.web.bind.annotation.*;


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

    //can use pathvariable too
    /*@GetMapping("/solve2/{number}")
    public Integer num(@PathVariable Integer number)*/
    @GetMapping("/solve2")
    public Integer num(@RequestParam(value = "number", defaultValue = "43256791") Integer number) {
        String temp = Integer.toString(number);
        int[] intArr = new int[temp.length()];
        StringBuilder res = new StringBuilder();
        int evenNum = 0;

        //insert numbers into int array
        for(int i = 0; i < temp.length(); i++) {
            intArr[i] = temp.charAt(i) - '0';
        }

        //change position to index + 1 of numbers which are <= 3
        for(int l = intArr.length - 1; l >= 0; l--) {
            if(intArr[l] <= 3 && (l != intArr.length - 1)) {
                int tempNum = intArr[l + 1];
                intArr[l + 1] = intArr[l];
                intArr[l] = tempNum;
            }
        }

        //append stringbuilder and do lefted changes with numbers
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

        //count even number
        for(int num = 0; num < res.length(); num++){
            if(res.charAt(num) % 2 == 0) {
                evenNum++;
            }
        }
        return (Integer.parseInt(res.toString()) / evenNum);
    }
}
