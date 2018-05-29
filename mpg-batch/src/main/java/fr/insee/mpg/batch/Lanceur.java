package fr.insee.mpg.batch;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.ws.WebServiceException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.log4j.Logger;

import fr.insee.config.InseeConfig;
import fr.insee.config.exception.PoolException;

/**
 * Cette classe rend des petits services communes à tous les batchs. Part du
 * principe qu'on lancera des batchs en simultané sur la même VM Java
 * 
 * @author Bruno Berlemont
 * @author OCTOPUSSE
 * @author Insee 2007
 * @version 1.0 16/08/2007
 * @since 1.0
 */
public abstract class Lanceur {
	private Lanceur() {
	}

	/**
	 * Point d'entrée d'exécution des batchs.
	 * 
	 * @param args
	 *            Le 1er paramètre est le nom codé du batch.
	 * @param une couleur pour les figures
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// on copie tous les arguments d'origine sauf le 1er qui est le
		// code du batch

		// LOGGER.INFO(INSEECONFIG.GETCONFIG().GETSTRING("FR.INSEE.CHEMINLOG"));
		String methode="main";
		String[] pargs = null;
		IBatch batch = null;
		pargs = retraitPremierArgument(args);
		batch = (IBatch) Class.forName(args[0]).newInstance();
		batch.executer(pargs);
	}

	public static String[] retraitPremierArgument(String[] args) {
		String[] pargs = null;
		if (args != null && args.length >= 2) {
			pargs = new String[args.length - 1];
			System.arraycopy(args, 1, pargs, 0, pargs.length);
		} else if (args != null) {
			pargs = new String[0];
		}
		return pargs;
	}
}
