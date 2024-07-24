package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author fbahceci
 * @since
 * @version %I%, %G%
 *
 */
public class HighchartsUtils {

	public enum DataType {
		X, Y
	}

	public static Object getChartData(WebDriver driver, String id, Integer serie, DataType type) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		StringBuilder sb = new StringBuilder();
		sb.append("return Highcharts.charts.find((element) => ");
		sb.append("element != null && element.renderTo.id === '");
		sb.append(id);
		sb.append("').");
		sb.append("series[");
		sb.append(serie == null ? "0" : serie.toString());
		sb.append("].");
		
		switch (type) {
		case X:
			sb.append("xData");
			break;
		case Y:
			sb.append("yData");
			break;
		default:
			sb.append("xData");
			break;
		}
		return js.executeScript(sb.toString());
	}

	public static Object getChartDataProperty(WebDriver driver, String chartId, int seriesIndex, int dataIndex, String property) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "var charts = Highcharts.charts;" +
					"for (var i = 0; i < charts.length; i++) {" +
					"   var chart = charts[i];" +
					"   if (chart && chart.renderTo.id === '" + chartId + "') {" +
					"       var series = chart.series[" + seriesIndex + "];" +
					"       if (series && series.data && series.data[" + dataIndex + "]) {" +
					"           return series.data[" + dataIndex + "]['" + property + "'];" +
					"       }" +
					"   }" +
					"}" +
					"return null;";
			return js.executeScript(script);
		}
	}


