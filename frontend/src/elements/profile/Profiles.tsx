import React, { useEffect, useState } from 'react'
import axios, { AxiosHeaders, AxiosRequestHeaders } from 'axios';
import axiosConf from '../../axiosConf';
import { Avatar, Button, Card } from 'antd';
import { ProfileInterface } from './ProfileInterface';
import Meta from 'antd/es/card/Meta';

function Profiles() {

    type profilePicDictType = {
        [key: string]: any;
      };

    const [profiles, setProfiles] = useState<ProfileInterface[]>([]);
    // это значение должно после загрузки поменяться, чтобы смысл useEffect сработал
    const [loadedSuccessfully, setLoadedSuccessfully] = useState<boolean>(false);
    const [profilePicDict, setProfilePicDict] = useState({} as profilePicDictType);
  
    useEffect(() => {
        getProfiles();
    }, [loadedSuccessfully])
  
    const getProfiles = () => {
      // const response = await axiosConf.get('/api/tasks', {headers:{'Authorization':'Bearer ' + localStorage.getItem('token')}});
      axiosConf.get('/api/profiles')
        .then((response) => {
            setProfiles(response.data);
            setLoadedSuccessfully(true);
        })
        .then(()=>{
            profiles.forEach(async (profile) =>{
                if (profile.sellerPic != null){
                    // const response = await axiosConf.get(`/api/profiles/pic/${profile.id}`)
                    const url = axiosConf.getUri() + `/api/profiles/pic/${profile.id}`
                    const response = await fetch(url);
                    const imageBlob = await response.blob();
                    const imageObjectURL = URL.createObjectURL(imageBlob);
                    setProfilePicDict({...profilePicDict, [profile.id]:imageObjectURL})
                }
            })
        })
        .catch(error => {
            console.log(error.response)
        })
    }
  
    // const fetchImage = async () => {
    //     const res = await fetch(imageUrl);
    //     const imageBlob = await res.blob();
    //     const imageObjectURL = URL.createObjectURL(imageBlob);
    //     setImg(imageObjectURL);
    //   };
    
    //   useEffect(() => {
    //     fetchImage();
    //   }, []);

    return (
        <>
            {
                profiles.map((profile, index) => (
                    // <Card key={profile.id}>
                    // <div className='user-card-content'>
                    //     <div className='user-card-content-element'>Title: {profile.title}</div>
                    //     <img 
                    //         style={{
                    //             width:'45px',
                    //             height:'45px'
                    //         }}
                    //         src={profilePicDict[profile.id]} 
                    //         alt="icons" 
                    //     />
                    //     <div className='user-card-content-element'>Description: {profile.description}</div>
                    // </div>
                    // {/* <Divider className='bottom-divider' orientation="left"></Divider> */}
                    // </Card>
                    <Card 
                    key={profile.id}
                    style={{ width: 300 }}
                    cover={
                        <img
                        alt="example"
                        src={profilePicDict[profile.id]} 
                        />
                    }
                    // actions={[
                    //     <SettingOutlined key="setting" />,
                    //     <EditOutlined key="edit" />,
                    //     <EllipsisOutlined key="ellipsis" />,
                    // ]}
                    >
                    <Meta
                        avatar={<Avatar src={profilePicDict[profile.id]}/>}
                        title={profile.title}
                        description={profile.description}
                    />
                    </Card>
                ))
            }
        </>
    )
}

export default Profiles