package nets150.cis.upenn.edu;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	private static Set<Connectome> experimental = new HashSet<Connectome>();
	private static Set<Connectome> control = new HashSet<Connectome>();
	
	private static void readInData(File directory, boolean exp) {
		String[] files = directory.list();
		for (String file : files) {
			String path = directory.getName() + "/" + file;
			Connectome c = new Connectome(path);
			if (exp) {
				experimental.add(c);
			} else {
				control.add(c);
			}
		}
	}
	
	public static void main(String args[]) {
		File exp = new File("AutismSpectrumDisorder");
		File cont = new File("TypicalDevelopment");
		readInData(exp, true);
		readInData(cont, false);
	
		System.out.println("Average average clustering coefficient for austitic spectrum disorder:");
		System.out.println("\t" + ClusteringCoefficient.groupAverageClusteringCoefficient(experimental));
		System.out.println("Average average clustering coefficient for typical development:");
		System.out.println("\t" + ClusteringCoefficient.groupAverageClusteringCoefficient(control));
		
		System.out.println("\n");
		
		System.out.println("Top 20 brain regions with highest average betweenness centrality for austitic spectrum disorder:");
		PriorityQueue<Betweenness> expQueue = BetweennessCentrality.avgBetweennessCentrality(experimental);
		for (int i = 0; i < 20; i++) {
			Betweenness b = expQueue.remove();
			System.out.println("\t" + nodeToBrainRegion(b.getNode()) + "(" + b.getNode() + "): " + b.getBetweenness());
		}
		System.out.println();
		System.out.println("Top 20 brain regions with highest average betweenness centrality for typical development:");
		PriorityQueue<Betweenness> contQueue = BetweennessCentrality.avgBetweennessCentrality(control);
		for (int i = 0; i < 20; i++) {
			Betweenness b = contQueue.remove();
			System.out.println("\t" + nodeToBrainRegion(b.getNode()) + "(" + b.getNode() + "): " + b.getBetweenness());
		}
		
		
		
	}
	
	private static String nodeToBrainRegion(int node) {
		switch(node) {
		case 0:
			return "Right Occipital Pole";
		case 1:
			return "Right Occipital Pole";
		case 2:
			return "Left Precuneous Cortex";
		case 3:
			return "Right Precuneous Cortex";
		case 4:
			return "Left Occipital Pole";
		case 5:
			return "Right Occipital Fusiform Gyrus";
		case 6:
			return "Right Cuneal Cortex";
		case 7:
			return "Left Lateral Occipital Cortex inferior division";
		case 8:
			return "Right Precuneous Cortex";
		case 9:
			return "Left Lateral Occipital Cortex inferior division";
		case 10:
			return "Left Occipital Pole";
		case 11:
			return "Right Occipital Pole";
		case 12:
			return "Left Occipital Pole";
		case 13:
			return "Right Lateral Occipital Cortex inferior division";
		case 14:
			return "Left Occipital Fusiform Gyrus";
		case 15:
			return "Left Occipital Fusiform Gyrus";
		case 16:
			return "Right Intracalcarine Cortex";
		case 17:
			return "Right Occipital Fusiform Gyrus";
		case 18:
			return "Right Lateral Occipital Cortex superior division";
		case 19:
			return "Left Intracalcarine Cortex";
		case 20:
			return "Right Lateral Occipital Cortex superior division";
		case 21:
			return "Left Occipital Pole";
		case 22:
			return "Left Cuneal Cortex";
		case 23:
			return "Right Superior Parietal Lobule";
		case 24:
			return "Right Temporal Occipital Fusiform Cortex";
		case 25:
			return "Left Lateral Occipital Cortex superior division";
		case 26:
			return "Right Lateral Occipital Cortex superior division";
		case 27:
			return "Left Lateral Occipital Cortex superior division";
		case 28:
			return "Left Cuneal Cortex";
		case 29:
			return "Right Lateral Occipital Cortex superior division";
		case 30:
			return "Right Intracalcarine Cortex";
		case 31:
			return "Right Lateral Occipital Cortex inferior division";
		case 32:
			return "Left Inferior Temporal Gyrus temporooccipital part";
		case 33:
			return "Right Occipital Pole";
		case 34:
			return "Right Parahippocampal Gyrus posterior division";
		case 35:
			return "Right Inferior Temporal Gyrus temporooccipital part";
		case 36:
			return "Right Cuneal Cortex";
		case 37:
			return "Right Intracalcarine Cortex";
		case 38:
			return "Left Superior Parietal Lobule";
		case 39:
			return "Left Lateral Occipital Cortex inferior division";
		case 40:
			return "Left Intracalcarine Cortex";
		case 41:
			return "Right Temporal Occipital Fusiform Cortex";
		case 42:
			return "Right Lateral Occipital Cortex inferior division";
		case 43:
			return "Left Inferior Temporal Gyrus temporooccipital part";
		case 44:
			return "Right Lingual Gyrus";
		case 45:
			return "Left Lingual Gyrus";
		case 46:
			return "Left Lingual Gyrus";
		case 47:
			return "Left Lateral Occipital Cortex inferior division";
		case 48:
			return "Right Precuneous Cortex";
		case 49:
			return "Right Lateral Occipital Cortex inferior division";
		case 50:
			return "Right Lateral Occipital Cortex superior division";
		case 51:
			return "Right Precentral Gyrus";
		case 52:
			return "Right Lateral Occipital Cortex superior division";
		case 53:
			return "Right Middle Temporal Gyrus temporooccipital part";
		case 54:
			return "Left Postcentral Gyrus";
		case 55:
			return "Left Precentral Gyrus";
		case 56:
			return "Left Postcentral Gyrus";
		case 57:
			return "Right Postcentral Gyrus";
		case 58:
			return "Left Precentral Gyrus";
		case 59:
			return "Left Precentral Gyrus";
		case 60:
			return "Right Precentral Gyrus";
		case 61:
			return "Right Precentral Gyrus";
		case 62:
			return "Right Temporal Fusiform Cortex posterior division";
		case 63:
			return "Left Postcentral Gyrus";
		case 64:
			return "Left Postcentral Gyrus";
		case 65:
			return "Right Postcentral Gyrus";
		case 66:
			return "Left Precentral Gyrus";
		case 67:
			return "Left Postcentral Gyrus";
		case 68:
			return "Right Postcentral Gyrus";
		case 69:
			return "Right Precentral Gyrus";
		case 70:
			return "Left Temporal Fusiform Cortex posterior division";
		case 71:
			return "Right Precentral Gyrus";
		case 72:
			return "Left Temporal Fusiform Cortex anterior division";
		case 73:
			return "Right Postcentral Gyrus";
		case 74:
			return "Right Superior Parietal Lobule";
		case 75:
			return "Right Precentral Gyrus";
		case 76:
			return "Right Postcentral Gyrus";
		case 77:
			return "Right Precentral Gyrus";
		case 78:
			return "Left Superior Parietal Lobule";
		case 79:
			return "Right Superior Parietal Lobule";
		case 80:
			return "Left VI";
		case 81:
			return "Right Inferior Temporal Gyrus posterior division";
		case 82:
			return "Right VI";
		case 83:
			return "Vermis VI";
		case 84:
			return "Left Precentral Gyrus";
		case 85:
			return "Left Precentral Gyrus";
		case 86:
			return "Left Postcentral Gyrus";
		case 87:
			return "Right Precentral Gyrus";
		case 88:
			return "Left Lateral Occipital Cortex superior division";
		case 89:
			return "Left Postcentral Gyrus";
		case 90:
			return "Right Parietal Operculum Cortex";
		case 91:
			return "Left Planum Temporale";
		case 92:
			return "Right Insular Cortex";
		case 93:
			return "Left Inferior Temporal Gyrus temporooccipital part";
		case 94:
			return "Left Postcentral Gyrus";
		case 95:
			return "Left Planum Temporale";
		case 96:
			return "Right Precentral Gyrus";
		case 97:
			return "Left Central Opercular Cortex";
		case 98:
			return "Left Cingulate Gyrus posterior division";
		case 99:
			return "Right Precuneous Cortex";
		case 100:
			return "Left Planum Temporale";
		case 101:
			return "Left Central Opercular Cortex";
		case 102:
			return "Brain-Stem";
		case 103:
			return "Right Planum Temporale";
		case 104:
			return "Right Insular Cortex";
		case 105:
			return "Right Central Opercular Cortex";
		case 106:
			return "Right Lateral Occipital Cortex superior division";
		case 107:
			return "Left Precuneous Cortex";
		case 108:
			return "Right Cingulate Gyrus anterior division";
		case 109:
			return "Left Juxtapositional Lobule Cortex";
		case 110:
			return "Left Insular Cortex";
		case 111:
			return "Right Postcentral Gyrus";
		case 112:
			return "Right Superior Frontal Gyrus";
		case 113:
			return "Left VI";
		case 114:
			return "Left Planum Temporale";
		case 115:
			return "Left Lateral Occipital Cortex inferior division";
		case 116:
			return "Right Postcentral Gyrus";
		case 117:
			return "Right Thalamus";
		case 118:
			return "Right Precentral Gyrus";
		case 119:
			return "Left Putamen";
		case 120:
			return "Left Superior Frontal Gyrus";
		case 121:
			return "Left Parietal Operculum Cortex";
		case 122:
			return "Right Thalamus";
		case 123:
			return "Left Thalamus";
		case 124:
			return "Right Putamen";
		case 125:
			return "Right Supramarginal Gyrus anterior division";
		case 126:
			return "Right Superior Frontal Gyrus";
		case 127:
			return "Right Superior Temporal Gyrus posterior division";
		case 128:
			return "Left Superior Parietal Lobule";
		case 129:
			return "Left Central Opercular Cortex";
		case 130:
			return "Left Juxtapositional Lobule Cortex";
		case 131:
			return "Right Putamen";
		case 132:
			return "Right Insular Cortex";
		case 133:
			return "Right Juxtapositional Lobule Cortex";
		case 134:
			return "Right Central Opercular Cortex";
		case 135:
			return "Left Central Opercular Cortex";
		case 136:
			return "Left Insular Cortex";
		case 137:
			return "Right Insular Cortex";
		case 138:
			return "Left Paracingulate Gyrus";
		case 139:
			return "Right Putamen";
		case 140:
			return "Left Frontal Pole";
		case 141:
			return "Right Middle Frontal Gyrus";
		case 142:
			return "Right Insular Cortex";
		case 143:
			return "Left Middle Frontal Gyrus";
		case 144:
			return "Left Insular Cortex";
		case 145:
			return "Right Precentral Gyrus";
		case 146:
			return "Right Pallidum";
		case 147:
			return "Left Cingulate Gyrus anterior division";
		case 148:
			return "Left Inferior Frontal Gyrus pars opercularis";
		case 149:
			return "Right Cingulate Gyrus anterior division";
		case 150:
			return "Left Frontal Pole";
		case 151:
			return "Right Frontal Pole";
		case 152: 
			return "Left Putamen";
		case 153:
			return "Right Paracingulate Gyrus";
		case 154:
			return "Right Frontal Orbital Cortex";
		case 155:
			return "Left Frontal Pole";
		case 156:
			return "Right Frontal Orbital Cortex";
		case 157:
			return "Right Thalamus";
		case 158:
			return "Left Superior Frontal Gyrus";
		case 159:
			return "Right Frontal Pole";
		case 160:
			return "Right Frontal Pole";
		case 161:
			return "Right Supramarginal Gyrus posterior division";
		case 162:
			return "Left Middle Frontal Gyrus";
		case 163:
			return "Left Cingulate Gyrus anterior division";
		case 164:
			return "Right Middle Frontal Gyrus";
		case 165:
			return "Right Inferior Frontal Gyrus pars triangularis";
		case 166:
			return "Right Insular Cortex";
		case 167:
			return "Left Caudate";
		case 168:
			return "Left Middle Frontal Gyrus";
		case 169:
			return "Right Frontal Pole";
		case 170:
			return "Right Frontal Pole";
		case 171:
			return "Right Frontal Pole";
		case 172:
			return "Left Cingulate Gyrus anterior division";
		case 173:
			return "Left Frontal Pole";
		case 174:
			return "Right Supramarginal Gyrus posterior division";
		case 175:
			return "Left Paracingulate Gyrus";
		case 176:
			return "Left Frontal Pole";
		case 177:
			return "Left Frontal Pole";
		case 178:
			return "Right Cingulate Gyrus anterior division";
		case 179:
			return "Left Paracingulate Gyrus";
		case 180:
			return "Left Supramarginal Gyrus posterior division";
		case 181:
			return "Right Middle Frontal Gyrus";
		case 182:
			return "Left Cingulate Gyrus anterior division";
		case 183:
			return "Right Angular Gyrus";
		case 184:
			return "Left Angular Gyrus";
		case 185:
			return "Right Frontal Pole";
		case 186:
			return "Right Middle Frontal Gyrus";
		case 187:
			return "Left Precentral Gyrus";
		case 188:
			return "Left Superior Frontal Gyrus";
		case 189:
			return "Right Frontal Orbital Cortex";
		case 190:
			return "Right Inferior Temporal Gyrus posterior division";
		case 191:
			return "Left Frontal Operculum Cortex";
		case 192:
			return "Right Inferior Frontal Gyrus pars triangularis";
		case 193:
			return "Left Frontal Pole";
		case 194:
			return "Left Cingulate Gyrus anterior division";
		case 195:
			return "Left Thalamus";
		case 196:
			return "Right Frontal Pole";
		case 197:
			return "Right Middle Temporal Gyrus posterior division";
		case 198:
			return "Right Paracingulate Gyrus";
		case 199:
			return "Right Frontal Pole";
		case 200:
			return "Right Angular Gyrus";
		case 201:
			return "Right Cingulate Gyrus posterior division";
		case 202:
			return "Right Lateral Occipital Cortex superior division";
		case 203:
			return "Left Paracingulate Gyrus";
		case 204:
			return "Left Cingulate Gyrus posterior division";
		case 205:
			return "Left Frontal Orbital Cortex";
		case 206:
			return "Left Superior Frontal Gyrus";
		case 207:
			return "Right Superior Frontal Gyrus";
		case 208:
			return "Right Paracingulate Gyrus";
		case 209:
			return "Left Paracingulate Gyrus";
		case 210:
			return "Right Middle Temporal Gyrus temporooccipital part";
		case 211:
			return "Left Frontal Pole";
		case 212:
			return "Right Middle Temporal Gyrus posterior division";
		case 213:
			return "Left Middle Frontal Gyrus";
		case 214:
			return "Right Crus I";
		case 215: 
			return "Right Superior Frontal Gyrus";
		case 216:
			return "Right Paracingulate Gyrus";
		case 217:
			return "Right Middle Temporal Gyrus posterior division";
		case 218:
			return "Right Frontal Pole";
		case 219:
			return "Left Frontal Orbital Cortex";
		case 220:
			return "Right Superior Temporal Gyrus posterior division";
		case 221:
			return "Right Angular Gyrus";
		case 222:
			return "Left Middle Temporal Gyrus temporooccipital part";
		case 223:
			return "Right Lateral Occipital Cortex superior division";
		case 224:
			return "Left Middle Temporal Gyrus posterior division";
		case 225:
			return "Left Middle Temporal Gyrus posterior division";
		case 226:
			return "Left Superior Frontal Gyrus";
		case 227:
			return "Right Frontal Pole";
		case 228:
			return "Left Lateral Occipital Cortex superior division";
		case 229:
			return "Left Cingulate Gyrus posterior division";
		case 230:
			return "Left Frontal Pole";
		case 231:
			return "Right Frontal Medial Cortex";
		case 232:
			return "Left Middle Temporal Gyrus posterior division";
		case 233:
			return "Left Lateral Occipital Cortex superior division";
		case 234:
			return "Right Crus II";
		case 235:
			return "Left Middle Temporal Gyrus posterior division";
		case 236:
			return "Left Frontal Pole";
		case 237:
			return "Left Paracingulate Gyrus";
		case 238:
			return "Right Frontal Medial Cortex";
		case 239:
			return "Left Lateral Occipital Cortex superior division";
		case 240:
			return "Left Middle Temporal Gyrus posterior division";
		case 241:
			return "Right Crus I";
		case 242:
			return "Left Temporal Fusiform Cortex posterior division";
		case 243:
			return "Right Frontal Pole";
		case 244:
			return "Left Lateral Occipital Cortex superior division";
		case 245:
			return "Left Hippocampus";
		case 246:
			return "Right Temporal Pole";
		case 247:
			return "Right Inferior Temporal Gyrus anterior division";
		case 248:
			return "Right Parahippocampal Gyrus posterior division";
		case 249:
			return "Right Middle Temporal Gyrus posterior division";
		case 250:
			return "Right Superior Temporal Gyrus anterior division";
		case 251:
			return "Right Temporal Pole";
		case 252:
			return "Right Precuneous Cortex";
		case 253:
			return "Left Lingual Gyrus";
		case 254:
			return "Right Cingulate Gyrus posterior division";
		case 255:
			return "Left Cingulate Gyrus posterior division";
		case 256:
			return "Left Parahippocampal Gyrus anterior division";
		case 257:
			return "Left Inferior Temporal Gyrus anterior division";
		case 258:
			return "Left Middle Temporal Gyrus anterior division";
		case 259:
			return "Right Precuneous Cortex";
		case 260:
			return "Left Middle Temporal Gyrus posterior division";
		case 261:
			return "Left Precuneous Cortex";
		case 262:
			return "Left Precuneous Cortex";
		case 263:
			return "Left Temporal Pole";
		default:
			return "";
		}
	}

}
