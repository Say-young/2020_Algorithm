using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using Vuforia;

public class cakeBtn : MonoBehaviour
{
    public GameObject vbBtnObj1;
    public GameObject vbBtnObj2;
    public GameObject vbBtnObj3;
    public GameObject vbBtnObj4;

    public Animator cakeAni;
    public Animator firework;
    public Animator firework2;
    public Animator pot;
    public Animator gifticon;

    public AudioSource song;
    public GameObject fire;
    public GameObject text;
    public GameObject smallFire;
    public GameObject bigFire;

    // Start is called before the first frame update
    void Start()
    {

        //각 버튼별로 선언
        vbBtnObj1 = GameObject.Find("actBtn");
        vbBtnObj1.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonPressed(OnButtonPressed);
        vbBtnObj1.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonReleased(OnButtonReleased);
        fire.SetActive(false);
        firework.GetComponent<Animator>();
        firework2.GetComponent<Animator>();

        vbBtnObj2 = GameObject.Find("actBtn2");
        vbBtnObj2.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonPressed(OnButtonPressed);
        vbBtnObj2.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonReleased(OnButtonReleased);
        cakeAni.GetComponent<Animator>();

        vbBtnObj3 = GameObject.Find("actBtn3");
        vbBtnObj3.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonPressed(OnButtonPressed);
        vbBtnObj3.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonReleased(OnButtonReleased);
        song.GetComponent<AudioSource>();
        pot.GetComponent<Animator>();
        gifticon.GetComponent<Animator>();

        vbBtnObj4 = GameObject.Find("actBtn4");
        vbBtnObj4.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonPressed(OnButtonPressed);
        vbBtnObj4.GetComponent<VirtualButtonBehaviour>().RegisterOnButtonReleased(OnButtonReleased);
        smallFire.SetActive(false);
        bigFire.SetActive(false);
        text.SetActive(false);
    }

    public void OnButtonPressed(VirtualButtonBehaviour vb)
    {
        if (vb.VirtualButtonName == "actBtn")
        {
            fire.SetActive(true);
            Debug.Log("BTN1 Pressed");
        }
        else if (vb.VirtualButtonName == "actBtn2")
        {
            cakeAni.Play("cake_ani");
            Debug.Log("BTN2 Pressed");
        }
        else if (vb.VirtualButtonName == "actBtn3")
        {
            song.loop = true;
            song.Play();
            gifticon.Play("gift");
            pot.Play("pot");
            Debug.Log("BTN3 Pressed");
        }
        else if (vb.VirtualButtonName == "actBtn4")
        {
            smallFire.SetActive(true);
            bigFire.SetActive(true);
            firework.Play("firework");
            firework2.Play("firework2");
            text.SetActive(true);
            Debug.Log("BTN4 Pressed");
        }
    }

    public void OnButtonReleased(VirtualButtonBehaviour vb)
    {
        smallFire.SetActive(false);
        bigFire.SetActive(false);
        fire.SetActive(false);
        song.Stop();
        pot.Play("none");
        gifticon.Play("none");
        cakeAni.Play("none");
        firework.Play("none");
        firework2.Play("none");
        text.SetActive(false);
        Debug.Log("BTN released");
    }

    // Update is called once per frame
    void Update()
    {

    }
}