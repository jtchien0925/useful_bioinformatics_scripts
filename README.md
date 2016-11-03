# useful_bioinformatics_scripts

1, fastq 2 fasta:

cat *.fastq | perl -e '$i=0;while(<>){if(/^\@/&&$i==0){s/^\@/>/;print;}elsif($i==1){s/./N/g;print;$i=-3}$i++;}' > fasta


2, For genome annotation, I uploaded the scripts of how to use maker for conducting annotation projects. 
