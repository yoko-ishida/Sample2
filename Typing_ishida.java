import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.lang.System;
import java.util.Scanner;



public class Typing_ishida {

    public static String[] get_ary_from_csv(int mondai_no) {
        String L00 = "mondai_ishida.csv";

        String[] ar_return = new String[5];

        try {

            //中身をすべて　仮の作業クラス　L01へ
            BufferedReader L01 = new BufferedReader(new FileReader(L00));
            //一行ずつ　変数L2へ　繰り返す
            String L02;

            //配列を一つ作って、一行ずつ入れる。
            int row = 5;
            String[][] ar_mondai = new String[row][5];

            row = 0;
            while ( (L02 = L01.readLine()) != null ) {
                String[] L03 = L02.split(",");
                ar_mondai[row][0] = L03[0];
                ar_mondai[row][1] = L03[1];
                ar_mondai[row][2] = L03[2];
                ar_mondai[row][3] = L03[3];
                ar_mondai[row][4] = L03[4];
                row++;
            }

            // System.out.println("返り値をとりあえず表示↓");
            // for (String vale : ar_mondai[0]) {
            //     System.out.println(vale);
            // }

            //引数で指定された行を配列で返す。
            ar_return = ar_mondai[mondai_no];


            //作業用のクラスを閉じる
            L01.close();
        } catch (FileNotFoundException L04) {
            System.out.println(L00 + "が見つかりませでした。");
        } catch (IOException L05) {
            System.out.println(L00 + "を読み込めませんでした。");
        }

        return ar_return;

    }



    public static void main(String[] args) {

//問題
        Scanner stdn2  = new Scanner(System.in);
        int selectContinue = 0;
        do {
            
            System.out.println("問題の種類を選択してください。");

            //問題をcsvから読み込む処理
            //問題（csv）の何行目かを指定して　関数で配列を取得
            System.out.println("0：ひらがな　1：カタカナ　2：数字　3：記号　4：その他");
            int mondai_no = new Scanner(System.in).nextInt();
            String[] mondai = get_ary_from_csv(mondai_no);


            System.out.println("表示される単語を入力してください。問題は" + mondai.length + "問です。");

            System.out.println("開始するにはEnterキーを押してください");

            try {
                System.in.read();
            } catch (IOException L01) {
            }

            //タイマースタート
            long L00 = System.currentTimeMillis();


            int count_ans = 0;
            String ans = "";
            for (int i = 0; i < mondai.length; i++) {
                System.out.print("問題" + (i + 1) + ":");
                System.out.println(mondai[i]);

                do {
                    Scanner stdn = new Scanner(System.in);
                    ans = stdn.nextLine();

                } while ( !ans.equals(mondai[i]) );

                System.out.println("正解。");
                count_ans++;

                if (count_ans == mondai.length) {
                    //タイマー終了
                    long L02 = System.currentTimeMillis();
                    System.out.printf("入力時間は、%.2f秒でした。", (L02 - L00) / 1000.0);

                    System.out.println("もう一度実行しますか？ 0:再度実行　1：終了");

                    selectContinue = stdn2.nextInt();

                }
            }
        } while (selectContinue == 0);





    }

}