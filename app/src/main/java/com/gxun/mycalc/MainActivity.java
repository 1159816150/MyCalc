package com.gxun.mycalc;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gxun.mycalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String calculation = "";
    String result = "";
    String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //设置点击相应
        binding.bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt0.getText().toString();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt1.getText().toString();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt2.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt3.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt4.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt5.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt6.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt7.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt8.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.bt9.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        binding.btDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.btDot.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        //加
        binding.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断字符串最后一位是否为运算符，如果是运算符则覆盖
                if (calculation.length()>0&&!ReversePolishMultiCalc.isNumber(calculation.substring(calculation.length()-1,calculation.length()))){
                    calculation=calculation.substring(0,calculation.length()-1);//字符串舍去最后一位
                    calculation += binding.btAdd.getText();
                    binding.textViewCalculation.setText(calculation);
                    //不为运算符则正常运算
                }else{
                    calculation += binding.btAdd.getText();
                    binding.textViewCalculation.setText(calculation);
                }
            }
        });
        //除
        binding.btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculation.length()>0&&!ReversePolishMultiCalc.isNumber(calculation.substring(calculation.length()-1,calculation.length()))){
                    calculation=calculation.substring(0,calculation.length()-1);
                    calculation += binding.btDiv.getText();
                    binding.textViewCalculation.setText(calculation);
                }else{
                    calculation += binding.btDiv.getText();
                    binding.textViewCalculation.setText(calculation);
                }
            }
        });
        //减
        binding.btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculation.length()>0&&!ReversePolishMultiCalc.isNumber(calculation.substring(calculation.length()-1,calculation.length()))){
                    calculation=calculation.substring(0,calculation.length()-1);
                    calculation += binding.btSub.getText();
                    binding.textViewCalculation.setText(calculation);
                }else{
                    calculation += binding.btSub.getText();
                    binding.textViewCalculation.setText(calculation);
                }
            }
        });
        //乘
        binding.btMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculation.length()>0&&!ReversePolishMultiCalc.isNumber(calculation.substring(calculation.length()-1,calculation.length()))){
                    Log.d(TAG, String.valueOf(!ReversePolishMultiCalc.isNumber(calculation.substring(calculation.length()-1,calculation.length()))));
                    calculation=calculation.substring(0,calculation.length()-1);
                    calculation += binding.btMul.getText();
                    binding.textViewCalculation.setText(calculation);
                }else{
                    calculation += binding.btMul.getText();
                    binding.textViewCalculation.setText(calculation);
                }
            }
        });
        binding.btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textViewCalculation.setText(calculation);
                try {
                    //判断运算字符串大于0且最后一个字符为数字
                    if (calculation.length()>0&&ReversePolishMultiCalc.isNumber(calculation.substring(calculation.length()-1,calculation.length()))) {
                       //当字符串只有一位数时，直接取结果
                        if (calculation.length()==1){
                           binding.textViewResult.setText(calculation);
                           result = "";    //结果清空
                       }
                       else {
                           //使用工具类ReversePolishMultiCalc进行运算
                           ReversePolishMultiCalc.doCalc(ReversePolishMultiCalc.doMatch(calculation));
                           result = String.valueOf(ReversePolishMultiCalc.RESULT);
                           binding.textViewResult.setText(result);
                           result = "";  //结果清空
                       }
                    }else
                    {
                        //当字符串只有2个字符时，直接获取数字结果
                        if (calculation.length()==2){
                            binding.textViewResult.setText( calculation.substring(0,calculation.length()-1));
                            result = "";   //结果清空
                        }else {
                            binding.textViewResult.setText("Illegal calculation");//运算字符串小于0且最后一个字符不为数字，输出Illegal
                            result = "";    //结果清空
                        }
                    }
                    } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        //取余
        binding.btRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation += binding.btRemainder.getText();
                binding.textViewCalculation.setText(calculation);
            }
        });
        //清零
        binding.btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation = "";
                binding.textViewCalculation.setText(calculation);
                binding.textViewResult.setText("0");
            }
        });
        //删除
        binding.imageViewDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculation.length() > 0) {
                    calculation = calculation.substring(0, calculation.length() - 1);
                }
                binding.textViewCalculation.setText(calculation);
            }
        });
    }
}
