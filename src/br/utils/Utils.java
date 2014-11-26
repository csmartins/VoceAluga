package br.utils;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Utils
{
	public static void exibirMensagem(String mensagem)
	{
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public static Date criarDataNoFuturo(int diasNoFuturo)
	{
		Date data = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DATE, diasNoFuturo);
		
		data = calendar.getTime();
		return data;
	}
}
