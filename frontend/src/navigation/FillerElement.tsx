import { Button, Input, Menu, Select } from 'antd'
import { Header } from 'antd/es/layout/layout'
import { ItemType } from 'antd/es/menu/hooks/useItems'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import requestIcon from './icons/order-svgrepo-com.png'
import logo_symbol from '../sc4(2).png'
// import logo_symbol from '../sc_logo.png'
import './navbar-style.css'
import { SearchOutlined } from '@ant-design/icons';
import { SearchProps } from 'antd/es/input/Search'
import ProductIcon from './icons/product/ProductIcon'
import BaseNavElement from './base/BaseNavElement'
import { hover } from '@testing-library/user-event/dist/hover'
import SpecialistsIcon from './icons/specialist/SpecialistsIcon'
import RequestsIcon from './icons/requests/RequestsIcon'
import BusinessesIcon from './icons/businesses/BusinessesIcon'
import ProductsMegaMenu from './megaMenus/ProductsMegaMenu'
import { relative } from 'path'
import ProfessionalsMegaMenu from './megaMenus/ProfessionalsMegaMenu'
import { useAppContext } from '../AppContext'
import LogoIcon from './icons/Logo'


function TopBarLight() {

  return (

    <div style={{display: 'flex', overflowY: 'auto', maxHeight: 'calc(100vh - var(--nav-height))'}}>
Background
Main article: Causes of World War II
Aftermath of World War I
The League of Nations assembly, held in Geneva, Switzerland (1930)

World War I had radically altered the political European map with the defeat of the Central Powers—including Austria-Hungary, Germany, Bulgaria, and the Ottoman Empire—and the 1917 Bolshevik seizure of power in Russia, which led to the founding of the Soviet Union. Meanwhile, the victorious Allies of World War I, such as France, Belgium, Italy, Romania, and Greece, gained territory, and new nation-states were created out of the dissolution of the Austro-Hungarian, Ottoman, and Russian Empires.[16]

To prevent a future world war, the League of Nations was established in 1920 by the Paris Peace Conference. The organisation's primary goals were to prevent armed conflict through collective security, military, and naval disarmament, as well as settling international disputes through peaceful negotiations and arbitration.[17]

Despite strong pacifist sentiment after World War I,[18] irredentist and revanchist nationalism had emerged in several European states. These sentiments were especially marked in Germany because of the significant territorial, colonial, and financial losses imposed by the Treaty of Versailles. Under the treaty, Germany lost around 13 percent of its home territory and all its overseas possessions, while German annexation of other states was prohibited, reparations were imposed, and limits were placed on the size and capability of the country's armed forces.[19]
Germany and Italy

The German Empire was dissolved in the German Revolution of 1918–1919, and a democratic government, later known as the Weimar Republic, was created. The interwar period saw strife between supporters of the new republic and hardline opponents on both the political right and left. Italy, as an Entente ally, had made some post-war territorial gains; however, Italian nationalists were angered that the promises made by the United Kingdom and France to secure Italian entrance into the war were not fulfilled in the peace settlement. From 1922 to 1925, the Fascist movement led by Benito Mussolini seized power in Italy with a nationalist, totalitarian, and class collaborationist agenda that abolished representative democracy, repressed socialist, left-wing, and liberal forces, and pursued an aggressive expansionist foreign policy aimed at making Italy a world power, promising the creation of a "New Roman Empire".[20]
Adolf Hitler at a German Nazi political rally in Nuremberg, August 1933

Adolf Hitler, after an unsuccessful attempt to overthrow the German government in 1923, eventually became the Chancellor of Germany in 1933 when Paul von Hindenburg and the Reichstag appointed him. Following Hindenburg's death in 1934, Hitler proclaimed himself Führer of Germany and abolished democracy, espousing a radical, racially motivated revision of the world order, and soon began a massive rearmament campaign.[21] France, seeking to secure its alliance with Italy, allowed Italy a free hand in Ethiopia, which Italy desired as a colonial possession. The situation was aggravated in early 1935 when the Territory of the Saar Basin was legally reunited with Germany, and Hitler repudiated the Treaty of Versailles, accelerated his rearmament programme, and introduced conscription.[22]
European treaties

The United Kingdom, France and Italy formed the Stresa Front in April 1935 in order to contain Germany, a key step towards military globalisation; however, that June, the United Kingdom made an independent naval agreement with Germany, easing prior restrictions. The Soviet Union, concerned by Germany's goals of capturing vast areas of Eastern Europe, drafted a treaty of mutual assistance with France. Before taking effect, though, the Franco-Soviet pact was required to go through the bureaucracy of the League of Nations, which rendered it essentially toothless.[23] The United States, concerned with events in Europe and Asia, passed the Neutrality Act in August of the same year.[24]

Hitler defied the Versailles and Locarno Treaties by remilitarising the Rhineland in March 1936, encountering little opposition due to the policy of appeasement.[25] In October 1936, Germany and Italy formed the Rome–Berlin Axis. A month later, Germany and Japan signed the Anti-Comintern Pact, which Italy joined the following year.[26]
Asia

The Kuomintang (KMT) party in China launched a unification campaign against regional warlords and nominally unified China in the mid-1920s, but was soon embroiled in a civil war against its former Chinese Communist Party (CCP) allies[27] and new regional warlords. In 1931, an increasingly militaristic Empire of Japan, which had long sought influence in China[28] as the first step of what its government saw as the country's right to rule Asia, staged the Mukden incident as a pretext to invade Manchuria and establish the puppet state of Manchukuo.[29]

China appealed to the League of Nations to stop the Japanese invasion of Manchuria. Japan withdrew from the League of Nations after being condemned for its incursion into Manchuria. The two nations then fought several battles, in Shanghai, Rehe and Hebei, until the Tanggu Truce was signed in 1933. Thereafter, Chinese volunteer forces continued the resistance to Japanese aggression in Manchuria, and Chahar and Suiyuan.[30] After the 1936 Xi'an Incident, the Kuomintang and CCP forces agreed on a ceasefire to present a united front to oppose Japan.[31]
Pre-war events
Italian invasion of Ethiopia (1935)
Main article: Second Italo-Ethiopian War
Benito Mussolini inspecting troops during the Italo-Ethiopian War, 1935

The Second Italo-Ethiopian War was a brief colonial war that began in October 1935 and ended in May 1936. The war began with the invasion of the Ethiopian Empire (also known as Abyssinia) by the armed forces of the Kingdom of Italy (Regno d'Italia), which was launched from Italian Somaliland and Eritrea.[32] The war resulted in the military occupation of Ethiopia and its annexation into the newly created colony of Italian East Africa (Africa Orientale Italiana, or AOI); in addition it exposed the weakness of the League of Nations as a force to preserve peace. Both Italy and Ethiopia were member nations, but the League did little when the former clearly violated Article X of the League's Covenant.[33] The United Kingdom and France supported imposing sanctions on Italy for the invasion, but the sanctions were not fully enforced and failed to end the Italian invasion.[34] Italy subsequently dropped its objections to Germany's goal of absorbing Austria.[35]
Spanish Civil War (1936–1939)
Main article: Spanish Civil War

When civil war broke out in Spain, Hitler and Mussolini lent military support to the Nationalist rebels, led by General Francisco Franco. Italy supported the Nationalists to a greater extent than the Nazis: Mussolini sent more than 70,000 ground troops, 6,000 aviation personnel, and 720 aircraft to Spain.[36] The Soviet Union supported the existing government of the Spanish Republic. More than 30,000 foreign volunteers, known as the International Brigades, also fought against the Nationalists. Both Germany and the Soviet Union used this proxy war as an opportunity to test in combat their most advanced weapons and tactics. The Nationalists won the civil war in April 1939; Franco, now dictator, remained officially neutral during World War II but generally favoured the Axis.[37] His greatest collaboration with Germany was the sending of volunteers to fight on the Eastern Front.[38]
Japanese invasion of China (1937)
Main article: Second Sino-Japanese War
Imperial Japanese Army soldiers during the Battle of Shanghai, 1937

In July 1937, Japan captured the former Chinese imperial capital of Peking after instigating the Marco Polo Bridge incident, which culminated in the Japanese campaign to invade all of China.[39] The Soviets quickly signed a non-aggression pact with China to lend materiel support, effectively ending China's prior cooperation with Germany. From September to November, the Japanese attacked Taiyuan, engaged the Kuomintang Army around Xinkou,[40] and fought Communist forces in Pingxingguan.[41][42] Generalissimo Chiang Kai-shek deployed his best army to defend Shanghai, but after three months of fighting, Shanghai fell. The Japanese continued to push Chinese forces back, capturing the capital Nanking in December 1937. After the fall of Nanking, tens or hundreds of thousands of Chinese civilians and disarmed combatants were murdered by the Japanese.[43][44]

In March 1938, Nationalist Chinese forces won their first major victory at Taierzhuang, but then the city of Xuzhou was taken by the Japanese in May.[45] In June 1938, Chinese forces stalled the Japanese advance by flooding the Yellow River; this manoeuvre bought time for the Chinese to prepare their defences at Wuhan, but the city was taken by October.[46] Japanese military victories did not bring about the collapse of Chinese resistance that Japan had hoped to achieve; instead, the Chinese government relocated inland to Chongqing and continued the war.[47][48]
Soviet–Japanese border conflicts
Main article: Soviet–Japanese border conflicts

In the mid-to-late 1930s, Japanese forces in Manchukuo had sporadic border clashes with the Soviet Union and Mongolia. The Japanese doctrine of Hokushin-ron, which emphasised Japan's expansion northward, was favoured by the Imperial Army during this time. This policy would prove difficult to maintain in light of the Japanese defeat at Khalkin Gol in 1939, the ongoing Second Sino-Japanese War[49] and ally Nazi Germany pursuing neutrality with the Soviets. Japan and the Soviet Union eventually signed a Neutrality Pact in April 1941, and Japan adopted the doctrine of Nanshin-ron, promoted by the Navy, which took its focus southward and eventually led to war with the United States and the Western Allies.[50][51]
European occupations and agreements
Chamberlain, Daladier, Hitler, Mussolini, and Ciano pictured just before signing the Munich Agreement, 29 September 1938

In Europe, Germany and Italy were becoming more aggressive. In March 1938, Germany annexed Austria, again provoking little response from other European powers.[52] Encouraged, Hitler began pressing German claims on the Sudetenland, an area of Czechoslovakia with a predominantly ethnic German population. Soon the United Kingdom and France followed the appeasement policy of British Prime Minister Neville Chamberlain and conceded this territory to Germany in the Munich Agreement, which was made against the wishes of the Czechoslovak government, in exchange for a promise of no further territorial demands.[53] Soon afterwards, Germany and Italy forced Czechoslovakia to cede additional territory to Hungary, and Poland annexed the Trans-Olza region of Czechoslovakia.[54]

Although all of Germany's stated demands had been satisfied by the agreement, privately Hitler was furious that British interference had prevented him from seizing all of Czechoslovakia in one operation. In subsequent speeches Hitler attacked British and Jewish "war-mongers" and in January 1939 secretly ordered a major build-up of the German navy to challenge British naval supremacy. In March 1939, Germany invaded the remainder of Czechoslovakia and subsequently split it into the German Protectorate of Bohemia and Moravia and a pro-German client state, the Slovak Republic.[55] Hitler also delivered an ultimatum to Lithuania on 20 March 1939, forcing the concession of the Klaipėda Region, formerly the German Memelland.[56]
German Foreign Minister Joachim von Ribbentrop (right) and the Soviet leader Joseph Stalin, after signing the Molotov–Ribbentrop Pact, 23 August 1939

Greatly alarmed and with Hitler making further demands on the Free City of Danzig, the United Kingdom and France guaranteed their support for Polish independence; when Italy conquered Albania in April 1939, the same guarantee was extended to the Kingdoms of Romania and Greece.[57] Shortly after the Franco-British pledge to Poland, Germany and Italy formalised their own alliance with the Pact of Steel.[58] Hitler accused the United Kingdom and Poland of trying to "encircle" Germany and renounced the Anglo-German Naval Agreement and the German–Polish declaration of non-aggression.[59]

The situation became a crisis in late August as German troops continued to mobilise against the Polish border. On 23 August the Soviet Union signed a non-aggression pact with Germany,[60] after tripartite negotiations for a military alliance between France, the United Kingdom, and Soviet Union had stalled.[61] This pact had a secret protocol that defined German and Soviet "spheres of influence" (western Poland and Lithuania for Germany; eastern Poland, Finland, Estonia, Latvia and Bessarabia for the Soviet Union), and raised the question of continuing Polish independence.[62] The pact neutralised the possibility of Soviet opposition to a campaign against Poland and assured that Germany would not have to face the prospect of a two-front war, as it had in World War I. Immediately afterwards, Hitler ordered the attack to proceed on 26 August, but upon hearing that the United Kingdom had concluded a formal mutual assistance pact with Poland and that Italy would maintain neutrality, he decided to delay it.[63]

In response to British requests for direct negotiations to avoid war, Germany made demands on Poland, which served as a pretext to worsen relations.[64] On 29 August, Hitler demanded that a Polish plenipotentiary immediately travel to Berlin to negotiate the handover of Danzig, and to allow a plebiscite in the Polish Corridor in which the German minority would vote on secession.[64] The Poles refused to comply with the German demands, and on the night of 30–31 August in a confrontational meeting with the British ambassador Nevile Henderson, Ribbentrop declared that Germany considered its claims rejected.[65]
Course of the war
For a chronological guide, see List of timelines of World War II.
See also: Diplomatic history of World War II and World War II by country
War breaks out in Europe (1939–1940)
Main article: European theatre of World War II
Soldiers of the Danzig Schutzpolizei tearing down the border crossing into Poland, 1 September 1939

On 1 September 1939, Germany invaded Poland after having staged several false flag border incidents as a pretext to initiate the invasion.[66] The first German attack of the war came against the Polish defenses at Westerplatte.[67] The United Kingdom responded with an ultimatum for Germany to cease military operations, and on 3 September, after the ultimatum was ignored, Britain and France declared war on Germany.[68] During the Phoney War period, the alliance provided no direct military support to Poland, outside of a cautious French probe into the Saarland.[69] The Western Allies also began a naval blockade of Germany, which aimed to damage the country's economy and war effort.[70] Germany responded by ordering U-boat warfare against Allied merchant and warships, which would later escalate into the Battle of the Atlantic.[71]

On 8 September, German troops reached the suburbs of Warsaw. The Polish counter-offensive to the west halted the German advance for several days, but it was outflanked and encircled by the Wehrmacht. Remnants of the Polish army broke through to besieged Warsaw. On 17 September 1939, two days after signing a cease-fire with Japan, the Soviet Union invaded Poland[72] under the supposed pretext that the Polish state had ceased to exist.[73] On 27 September, the Warsaw garrison surrendered to the Germans, and the last large operational unit of the Polish Army surrendered on 6 October. Despite the military defeat, Poland never surrendered; instead, it formed the Polish government-in-exile and a clandestine state apparatus remained in occupied Poland.[74] A significant part of Polish military personnel evacuated to Romania and Latvia; many of them later fought against the Axis in other theatres of the war.[75]

Germany annexed western Poland and occupied central Poland; the Soviet Union annexed eastern Poland; small shares of Polish territory were transferred to Lithuania and Slovakia. On 6 October, Hitler made a public peace overture to the United Kingdom and France but said that the future of Poland was to be determined exclusively by Germany and the Soviet Union. The proposal was rejected[65] and Hitler ordered an immediate offensive against France,[76] which was postponed until the spring of 1940 due to bad weather.[77][78][79]
Mannerheim Line and Karelian Isthmus on the last day of the Winter War, 13 March 1940

After the outbreak of war in Poland, Stalin threatened Estonia, Latvia, and Lithuania with military invasion, forcing the three Baltic countries to sign pacts allowing the creation of Soviet military bases in these countries; in October 1939, significant Soviet military contingents were moved there.[80][81][82] Finland refused to sign a similar pact and rejected ceding part of its territory to the Soviet Union. The Soviet Union invaded Finland in November 1939,[83] and was subsequently expelled from the League of Nations for this crime of aggression.[84] Despite overwhelming numerical superiority, Soviet military success during the Winter War was modest,[85] and the Finno-Soviet war ended in March 1940 with some Finnish concessions of territory.[86]

In June 1940, the Soviet Union occupied the entire territories of Estonia, Latvia and Lithuania,[81] as well as the Romanian regions of Bessarabia, Northern Bukovina, and the Hertsa region. In August 1940, Hitler imposed the Second Vienna Award on Romania which led to the transfer of Northern Transylvania to Hungary.[87] In September 1940, Bulgaria demanded Southern Dobruja from Romania with German and Italian support, leading to the Treaty of Craiova.[88] The loss of one-third of Romania's 1939 territory caused a coup against King Carol II, turning Romania into a fascist dictatorship under Marshal Ion Antonescu, with a course set towards the Axis in the hopes of a German guarantee.[89] Meanwhile, German-Soviet political relations and economic co-operation[90][91] gradually stalled,[92][93] and both states began preparations for war.[94] 
    </div>
  )
}

export default TopBarLight